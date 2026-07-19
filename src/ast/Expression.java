package ast;

import java.util.List;

public abstract class Expression extends Node {
    public Expression(String type, Object value, List<Node> children) {
        super(type, value, children);
    }

    public Expression(String type, Object value, List<Node> children, Node parent) {
        super(type, value, children, parent);
    }

}
