package ast.statement;

import ast.*;

public class PrintNode extends Statement {
    public PrintNode(Expression expr) {
        super(NodeEnum.PRINT, "", null);
        if (expr != null) addChild(expr);
    }
}