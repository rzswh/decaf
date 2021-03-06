package decaf.backend.asm.mips;

import decaf.backend.asm.SubroutineEmitter;
import decaf.backend.asm.SubroutineInfo;
import decaf.lowlevel.Mips;
import decaf.lowlevel.instr.NativeInstr;
import decaf.lowlevel.instr.Reg;
import decaf.lowlevel.instr.Temp;
import decaf.lowlevel.label.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Emit MIPS assembly code for a subroutine.
 * <p>
 * Recall the stack frame of a MIPS subroutine looks this:
 * <pre>
 *                  previous stack frame ...
 * SP + 4n + 36 + : local data m - 1
 * 4(m - 1)
 *               ...
 * SP + 4n + 36   : local data 0
 * SP + 4n + 32   : ($RA)
 * SP + 4n + 28   : ($S7)
 * The parenthesized slots may not be used, but to make our life easier, we always reserve them.
 */
public class MipsSubroutineEmitter extends SubroutineEmitter {

    MipsSubroutineEmitter(MipsAsmEmitter emitter, SubroutineInfo info) {
        super(emitter, info);
        nextLocalOffset = info.argsSize + 36;
        printer.printLabel(info.funcLabel, "function " + info.funcLabel.prettyString());
    }

    @Override
    public void emitStoreToStack(Reg src) {
        if (!offsets.containsKey(src.temp)) {
            if (src.temp.index < info.numArg) { // Always map arg `i` to `SP + 4 * i`.
                offsets.put(src.temp, 4 * src.temp.index);
        nextLocalOffset = info.argsSize + 36;

        buf.add(new Mips.NativeStoreWord(src, Mips.SP, offsets.get(src.temp)));
    }

    @Override
    public void emitLoadFromStack(Reg dst, Temp src) {
        if (!offsets.containsKey(src)) {
            if (src.index < info.numArg) { // arg
                var offset = 4 * src.index;
                offsets.put(src, offset);
                buf.add(new Mips.NativeLoadWord(dst, Mips.SP, offset));
                return;
            }

            throw new IllegalArgumentException("offsets doesn't contain " + src + " when loading " + dst);
        }

        buf.add(new Mips.NativeLoadWord(dst, Mips.SP, offsets.get(src)));
    }

    @Override
    public void emitMove(Reg dst, Reg src) {
        buf.add(new Mips.NativeMove(dst, src));
    }

    @Override
    public void emitNative(NativeInstr instr) {
        buf.add(instr);
    }

    @Override
    public void emitLabel(Label label) {
        buf.add(new Mips.MipsLabel(label).toNative(new Reg[]{}, new Reg[]{}));
    }

    @Override
    public void emitEnd() {
        printer.printComment("start of prologue");
        printer.printInstr(new Mips.SPAdd(-nextLocalOffset), "push stack frame");
        // move arguments in stacks
        int offset = nextLocalOffset - info.numArg * 4;
        for (int i = 4; i < info.numArg; i++) {
            printer.printInstr(new Mips.NativeLoadWord(Mips.T0, Mips.SP, i * 4 + offset));
            printer.printInstr(new Mips.NativeStoreWord(Mips.T0, Mips.SP, i * 4));
        }
        if (Mips.RA.isUsed() || info.hasCalls) {
            printer.printInstr(new Mips.NativeStoreWord(Mips.RA, Mips.SP, info.argsSize + 32),
                    "save the return address");
        }
        for (var i = 0; i < Mips.calleeSaved.length; i++) {
            if (Mips.calleeSaved[i].isUsed()) {
                printer.printInstr(new Mips.NativeStoreWord(Mips.calleeSaved[i], Mips.SP, info.argsSize + 4 * i),
        // move arguments in stacks
        int offset = nextLocalOffset - info.numArg * 4;
        for (int i = 4; i < info.numArg; i++) {
            printer.printInstr(new Mips.NativeLoadWord(Mips.T0, Mips.SP, i * 4 + offset));
            printer.printInstr(new Mips.NativeStoreWord(Mips.T0, Mips.SP, i * 4));
        }
        if (Mips.RA.isUsed() || info.hasCalls) {
            printer.printInstr(new Mips.NativeStoreWord(Mips.RA, Mips.SP, info.argsSize + 32),
        }
        printer.printComment("end of body");
        printer.println();

        printer.printLabel(new Label(info.funcLabel.name + Mips.EPILOGUE_SUFFIX));
        printer.printComment("start of epilogue");
        for (var i = 0; i < Mips.calleeSaved.length; i++) {
            if (Mips.calleeSaved[i].isUsed()) {
                printer.printInstr(new Mips.NativeLoadWord(Mips.calleeSaved[i], Mips.SP, info.argsSize + 4 * i),
                        "restore value of $S" + i);
            }
        }
        for (var i = 0; i < Math.min(info.numArg, 4); i++) {
            printer.printInstr(new Mips.NativeStoreWord(Mips.argRegs[i], Mips.SP, 4 * i),
                    "save arg " + i);
        }
}
            printer.printInstr(new Mips.NativeLoadWord(Mips.RA, Mips.SP, info.argsSize + 32),
