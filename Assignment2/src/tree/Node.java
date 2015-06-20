package tree;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private T data; // node data
    private Node<T> left, right; // left child and right child
    private int height; //height of node

    public Node(T data) {
        this(data, null, null);
    }

    public Node(T data, Node<T> left, Node<T> right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
        
        // set height of given node
        if (left == null && right == null) {
            this.height = 1;
        } else if (left == null) {
            this.height = right.getHeight() + 1;
        } else if (right == null) {
            this.height = left.getHeight() + 1;
        } else {
            this.height = Math.max(left.getHeight(), right.getHeight()) + 1;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
