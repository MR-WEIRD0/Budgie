package ast.statement;

import ast.*;

public class PrintNode extends Statement {
    public PrintNode(Expression expr) {
        super("Print", "", null);
        addChild(expr);
    }
}