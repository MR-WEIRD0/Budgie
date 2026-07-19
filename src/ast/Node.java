package ast;

import java.util.*;
import util.Error;
import ast.*;

public abstract class Node {
    private final List<Node> children;
    private final NodeEnum type;
    protected final Object value;
    private Node parent;

    protected Node(NodeEnum type, Object value, List<Node> children, Node parent) {
        this(type, value, children);
        this.parent = parent;
    }

    protected Node(NodeEnum type, Object value, List<Node> children) {
        if (type == null) new Error("Internal Error: Missing Node Type");
        this.type = type;
        this.value = value;
        this.children = (children != null) ? new ArrayList<>(children) : new ArrayList<>();
    }

    public List<Node> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public Node getChild(int idx) {
        return children.get(idx);
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public Object getValue() {
        return value;
    }

    public NodeEnum getType() {
        return type;
    }

    public void addChild(Node child) {
        children.add(child);
        child.setParent(this);
    }

    @Override
    public String toString() {
        return "Node{Type: " + type + ", Value: " + value + "}";
    }
}
