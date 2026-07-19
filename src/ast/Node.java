package ast;

import java.util.*;
import util.Error;

public abstract class Node {
    private final List<Node> children;
    private final String type;
    protected final Object value;
    private Node parent;

    protected Node(String type, Object value, List<Node> children, Node parent) {
        this(type, value, children);
        this.parent = parent;
    }

    protected Node(String type, Object value, List<Node> children) {
        if (type == null || type.isBlank()) new Error("Internal Error: Missing Node Type");
        this.type = type;
        this.value = value;
        this.children = (children != null) ? new ArrayList<>(children) : new ArrayList<>();
    }

    public List<Node> getChildren() {
        return Collections.unmodifiableList(children);
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

    public String getType() {
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
