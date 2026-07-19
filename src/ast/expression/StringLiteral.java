package ast.expression;

import ast.*;

public class StringLiteral extends Expression {
    public StringLiteral(String value) {
        super(NodeEnum.STRING, value, null);
    }
}
