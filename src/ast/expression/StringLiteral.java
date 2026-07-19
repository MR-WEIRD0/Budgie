package ast.expression;

import ast.*;

public class StringLiteral extends Expression {
    public StringLiteral(String value) {
        super("String", value, null);
    }
}
