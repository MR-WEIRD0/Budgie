package ast;

import java.util.List;

public abstract class Statement extends Node {
    public Statement(String type, Object value, List<Node> children) {
        super(type, value, children);
    }

    public Statement(String type, Object value, List<Node> children, Node parent) {
        super(type, value, children, parent);
    }
}
