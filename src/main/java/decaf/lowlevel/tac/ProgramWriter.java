package decaf.lowlevel.tac;

import decaf.lowlevel.label.FuncLabel;
import decaf.lowlevel.label.Label;

import java.util.*;

/**
 * High-level helper methods which can guide you to generate a TAC program, without knowing the underlying instruction
 * encoding.
 */
public class ProgramWriter {

    /**
     * Constructor.
     *
     * @param classes basic info of classes declared in the program (warning: the arg will be modified by this method).
     */
    public ProgramWriter(List<ClassInfo> classes) {
        for (var clazz : classes) {
            this.classes.put(clazz.name, clazz);
        }
    }

    /**
     * Generate TAC code for virtual tables.
     */
    public void visitVTables() {
        // Allocate labels for every method, including the constructor <init>, which initializes an object.
        for (var clazz : classes.values()) {
            ctx.putConstructorLabel(clazz.name);
            for (var method : clazz.methods) {
                ctx.putFuncLabel(clazz.name, method);
                if (!(clazz.isMainClass && method.equals("main")))
                    ctx.putFuncLabel(clazz.name + "__", method);
            }
        }

        // Build virtual tables.
        for (var clazz : classes.values()) {
            buildVTableFor(clazz);
        }
        buildCommonVTable(CLASS_ARRAY_LENGTH);
        ctx.putVTable(new VTable(CLASS_LAMBDA_CALLER, Optional.empty()));

        // Create the `new` method for every class.
        for (var clazz : classes.values()) {
            createConstructorFor(clazz.name);
        }

    }

    private FuncLabel buildArrayLength() {
        var label = ctx.getFuncLabel(CLASS_ARRAY_LENGTH, METHOD_ARRAY_LENGTH);
        if (label != null) return label;
        ctx.putFuncLabel(CLASS_ARRAY_LENGTH, METHOD_ARRAY_LENGTH);
        label = ctx.getFuncLabel(CLASS_ARRAY_LENGTH, METHOD_ARRAY_LENGTH);
        FuncVisitor mv = new FuncVisitor(label, 1, ctx);
        mv.visitArrayLengthCaller();
        mv.visitEnd();
        return label;
    }

    /**
     * Generate TAC code for the main method.
     */
    public FuncVisitor visitMainMethod() {
        var entry = FuncLabel.MAIN_LABEL;
        return new FuncVisitor(entry, 0, ctx);
    }

    /**
     * Generate TAC code for a normal function.
     *
     * @param className class name
     * @param funcName  function name
     * @param numArgs   number of arguments
     */
    public FuncVisitor visitFunc(String className, String funcName, int numArgs) {
        var entry = ctx.getFuncLabel(className, funcName);
        return new FuncVisitor(entry, numArgs, ctx);
    }

    /**
     * Generate TAC entry function of function object
     */
    public void visitFuncObject(String className, String funcName, int numArgs, boolean isStatic, boolean needReturn) {
        var entry = ctx.getFuncLabel(className + "__", funcName);
        FuncVisitor mv = new FuncVisitor(entry, numArgs + (isStatic ? 1 : 0), ctx);
        if (isStatic)
            mv.visitStaticFuncCaller(className, funcName, numArgs, needReturn);
        else
            mv.visitMemberFuncCaller(className, funcName, numArgs - 1, needReturn);
        mv.visitEnd();
    }
    /**
     * Call this when all functions are done.
     *
     * @return TAC program
     */
    public TacProg visitEnd() {
        return new TacProg(ctx.getVTables(), ctx.funcs);
    }

    private HashMap<String, ClassInfo> classes = new HashMap<>();

    private Context ctx = new Context();

    /**
     * Emit code for initializing a new object. In memory, an object takes 4 * (1 + number of member variables) bytes,
     * where:
     * - the first 4 bytes: address of its virtual table
     * - next bytes: values/references of every member variables
     *
     * @param clazz class name
     */
    private void createConstructorFor(String clazz) {
        var entry = ctx.getConstructorLabel(clazz);
        var mv = new FuncVisitor(entry, 0, ctx);

        var vtbl = ctx.getVTable(clazz);
        var size = mv.visitLoad(vtbl.getObjectSize());
        var object = mv.visitIntrinsicCall(Intrinsic.ALLOCATE, true, size);
        var addr = mv.visitLoadVTable(clazz);
        mv.visitStoreTo(object, addr); // the first 4 bytes: address of its virtual table
        mv.visitReturn(object);
        mv.visitEnd();
    }

    private void buildVTableFor(ClassInfo clazz) {
        if (ctx.hasVTable(clazz.name)) return;

        var parent = clazz.parent.map(c -> {
            buildVTableFor(classes.get(c));
            return ctx.getVTable(c);
        });
        var vtbl = new VTable(clazz.name, parent);
        var vtblCaller = new VTable(clazz.name + "__", Optional.empty());

        // Member methods consist of ones that are:
        // 1. inherited from super class
        // 2. overriden by this class

        if (parent.isPresent()) {
            for (var lbl : parent.get().memberMethods) {
                var method = lbl.method;
                if (clazz.memberMethods.contains(method)) {
                    vtbl.memberMethods.add(ctx.getFuncLabel(clazz.name, method));
                    clazz.memberMethods.remove(method);
                    Optional.ofNullable(ctx.getFuncLabel(clazz.name + "__", method))
                            .ifPresent(x->vtblCaller.memberMethods.add(x));
                } else {
                    vtbl.memberMethods.add(lbl);
                    Optional.ofNullable(ctx.getFuncLabel(lbl.clazz + "__", lbl.method))
                            .ifPresent(x->vtblCaller.memberMethods.add(x));
                }
            }
        }

        // 3. newly declared in this class
        for (var method : clazz.memberMethods) {
            vtbl.memberMethods.add(ctx.getFuncLabel(clazz.name, method));
            Optional.ofNullable(ctx.getFuncLabel(clazz.name + "__", method))
                    .ifPresent(x->vtblCaller.memberMethods.add(x));
        }

        for (var method: clazz.staticMethods) {
            Optional.ofNullable(ctx.getFuncLabel(clazz.name + "__", method))
                    .ifPresent(x->vtblCaller.memberMethods.add(x));
        }

        // Similarly, member variables consist of ones that are:
        // 1. inherited from super class
        // 2. overriden by this class (Decaf doesn't support this, but handle it for future)

        if (parent.isPresent()) {
            for (var variable : parent.get().memberVariables) {
                clazz.memberVariables.remove(variable);
                vtbl.memberVariables.add(variable);
            }
        }

        // 3. newly declared in this class
        vtbl.memberVariables.addAll(clazz.memberVariables);

        ctx.putVTable(vtbl);
        ctx.putOffsets(vtbl);
        ctx.putVTable(vtblCaller);
        ctx.putOffsets(vtblCaller);
    }

    private void buildCommonVTable(String name) {
        var vtbl = new VTable(name, Optional.empty());
        vtbl.memberMethods.add(buildArrayLength());

        ctx.putVTable(vtbl);
        ctx.putOffsets(vtbl);
    }

    class Context {

        void putConstructorLabel(String clazz) {
            putFuncLabel(clazz, "new");
        }

        FuncLabel getConstructorLabel(String clazz) {
            return getFuncLabel(clazz, "new");
        }

        void putFuncLabel(String clazz, String method) {
            labels.put(clazz + "." + method, new FuncLabel(clazz, method));
        }

        FuncLabel getFuncLabel(String clazz, String method) {
            return labels.get(clazz + "." + method);
        }

        Label freshLabel() {
            var name = "_L" + nextTempLabelId;
            nextTempLabelId++;
            return new Label(name);
        }

        VTable getVTable(String clazz) {
            return vtables.get(clazz);
        }

        boolean hasVTable(String clazz) {
            return vtables.containsKey(clazz);
        }

        void putVTable(VTable vtbl) {
            vtables.put(vtbl.className, vtbl);
        }

        List<VTable> getVTables() {
            return new ArrayList<>(vtables.values());
        }

        int getOffset(String clazz, String member) {
            return offsets.get(clazz + "." + member);
        }

        void putOffsets(VTable vtbl) {
            var prefix = vtbl.className + ".";

            var offset = 8;
            for (var l : vtbl.memberMethods) {
                offsets.put(prefix + l.method, offset);
                offset += 4;
            }

            offset = 4;
            for (var variable : vtbl.memberVariables) {
                offsets.put(prefix + variable, offset);
                offset += 4;
            }
        }

        void appendFunc(String clazz, String method) {
            FuncLabel label = getFuncLabel(clazz, method);
            if (label == null) {
                putFuncLabel(clazz, method);
                label = getFuncLabel(clazz, method);
            }
            var vtable = getVTable(clazz);
            vtable.memberMethods.add(label);
            putOffsets(vtable);
        }

        private Map<String, FuncLabel> labels = new TreeMap<>();

        private Map<String, VTable> vtables = new TreeMap<>();

        private Map<String, Integer> offsets = new TreeMap<>();

        List<TacFunc> funcs = new ArrayList<>();

        private int nextTempLabelId = 1;
    }

    public static final String CLASS_ARRAY_LENGTH = "Array__";
    public static final String CLASS_LAMBDA_CALLER = "LambdaCaller__";
    public static final String METHOD_ARRAY_LENGTH = "Array.getLength";
    public static final String CLASS_LAMBDA = "Lambda__";

}
