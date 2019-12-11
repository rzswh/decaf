package decaf.frontend.tacgen;

import decaf.frontend.symbol.LambdaSymbol;
import decaf.frontend.symbol.VarSymbol;
import decaf.frontend.tree.Tree;
import decaf.lowlevel.instr.Temp;
import decaf.lowlevel.tac.FuncVisitor;

import java.util.ArrayList;
import java.util.List;

public class LambdaEmitter implements TacEmitter {

    private LambdaSymbol lambdaSymbol;

    private int argCount;

    public LambdaEmitter(LambdaSymbol symbol, int argCount) {
        this.lambdaSymbol = symbol;
        this.argCount = argCount;
    }

    private Temp getCaptured(String name, FuncVisitor mv) {
        int capturedNum = lambdaSymbol.captured.size();
        for (int i = 0; i < capturedNum; i++) {
            var s = lambdaSymbol.captured.get(i);
            if (name.equals(s.name)) {
                return mv.getArgTemp(i + argCount - capturedNum);
            }
        }
        assert false; // Something missed!
        return null;
    }

    @Override
    public List<Temp> getTempForCaptured(List<VarSymbol> captured, FuncVisitor mv) {
        var args = new ArrayList<Temp>();
        for (VarSymbol s : captured) {
            if ("this".equals(s.name) || lambdaSymbol.scope.lookupWithin(s).isEmpty()) {
                args.add(getCaptured(s.name, mv));
            } else args.add(s.temp);
        }
        assert args.size() == captured.size();
        return args;
    }

    @Override
    public void visitVarSel(Tree.VarSel expr, FuncVisitor mv) {
        if (expr.receiver.isEmpty() && expr.symbol.isVarSymbol()
                && lambdaSymbol.scope.lookupWithin(expr.symbol).isEmpty()) {
            expr.val = getCaptured(expr.symbol.name, mv);
            return;
        }
        TacEmitter.super.visitVarSel(expr, mv);
    }

    @Override
    public void visitThis(Tree.This expr, FuncVisitor mv) {
        expr.val = getCaptured("this", mv);
    }
}
