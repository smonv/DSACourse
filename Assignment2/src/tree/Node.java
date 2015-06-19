package tree;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private T data;
    private Node<T> left, right;
    public int level;
    private int depth;

    public Node(T data) {
        this(data, null, null);
    }

    public Node(T data, Node<T> left, Node<T> right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
        if (left == null && right == null) {
            setDepth(1);
        } else if (left == null) {
            setDepth(right.getDepth() + 1);
        } else if (right == null) {
            setDepth(left.getDepth() + 1);
        } else {
            setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
        }

    }

    @Override
    public int compareTo(Node<T> o) {
        return this.data.compareTo(o.data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Level " + level + ": " + data;
    }
}
