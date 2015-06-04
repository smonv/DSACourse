package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public BinaryTree() {
        this(null);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void breadthFirstSearch() {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n.getLeft() != null) {
                q.add(n.getLeft());
            }
            if (n.getRight() != null) {
                q.add(n.getRight());
            }
            System.out.println(n.getValue());
        }
    }

    public void deepthFirstTravelsal(Node n) {
        if (n == null) {
            return;
        } else {
            System.out.println(n.getValue());
            deepthFirstTravelsal(n.getLeft());
            deepthFirstTravelsal(n.getRight());
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
