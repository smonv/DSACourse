package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVLTree<T extends Comparable<T>> {

    Node<T> root;

    public AVLTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T max() {
        Node<T> local = root;
        if (local == null) {
            return null;
        }
        while (local.getRight() != null) {
            local = local.getRight();
        }
        return local.getData();
    }

    public T min() {
        Node<T> local = root;
        if (local == null) {
            return null;
        }
        while (local.getLeft() != null) {
            local = local.getLeft();
        }
        return local.getData();
    }

    private int depth(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    public Node<T> insert(T data) {
        root = insert(root, data);
        switch (balanceNumber(root)) {
            case 2:
                root = rotateLeft(root);
                break;
            case -2:
                root = rotateRight(root);
                break;
            default:
                break;
        }
        return root;
    }

    public Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        // compare and recursive insert to child node
        if (node.getData().compareTo(data) > 0) {
            node = new Node<>(node.getData(), insert(node.getLeft(), data), node.getRight());
        } else if (node.getData().compareTo(data) < 0) {
            node = new Node<>(node.getData(), node.getLeft(), insert(node.getRight(), data));
        }
        // After insert the new node, check and rebalance the current node if
        // necessary.
        switch (balanceNumber(node)) {
            case 1:
                node = rotateLeft(node);
                break;
            case -1:
                node = rotateRight(node);
                break;
            default:
                return node;
        }
        return node;
    }

    // Simple remove node, recreate AVL Tree to ensure tree will be balanced
    public AVLTree<T> remove(T data) {
        AVLTree<T> temp = new AVLTree<>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            if (node.getData().compareTo(data) != 0) {
                temp.insert(node.getData());
            }
            Node<T> left = node.getLeft();
            Node<T> right = node.getRight();
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
        return temp;
    }

    private int balanceNumber(Node<T> node) {
        int L = depth(node.getLeft());
        int R = depth(node.getRight());
        if (L - R >= 2) {
            return -1;
        } else if (L - R <= -2) {
            return 1;
        }
        return 0;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> q = node;
        Node<T> p = q.getRight();
        Node<T> c = q.getLeft();
        Node<T> a = p.getLeft();
        Node<T> b = p.getRight();
        q = new Node<>(q.getData(), c, a);
        p = new Node<>(p.getData(), q, b);
        return p;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> q = node;
        Node<T> p = q.getLeft();
        Node<T> c = q.getRight();
        Node<T> a = p.getLeft();
        Node<T> b = p.getRight();
        q = new Node<>(q.getData(), b, c);
        p = new Node<>(p.getData(), a, q);
        return p;
    }

    public T search(T data) {
        Node<T> local = root;
        while (local != null) {
            if (local.getData().compareTo(data) == 0) {
                return local.getData();
            } else if (local.getData().compareTo(data) > 0) {
                local = local.getLeft();
            } else {
                local = local.getRight();
            }
        }
        return null;
    }

    public int count() {
        return count(root);
    }

    public int count(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            int count = 1;
            count += count(node.getLeft());
            count += count(node.getRight());
            return count;
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public void breathFirstTraverse() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            System.out.println(node.getData());
            Node<T> left = node.getLeft();
            Node<T> right = node.getRight();
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
    }

    public void inOrderTraverse(Node<T> local) {
        if (local != null) {
            inOrderTraverse(local.getLeft());
            System.out.println(local.getData());
            inOrderTraverse(local.getRight());
        }
    }

    public void preOrderTraverse(Node<T> local) {
        if (local != null) {
            System.out.println(local.getData());
            preOrderTraverse(local.getLeft());
            preOrderTraverse(local.getRight());
        }
    }

    public List<T> inOrderTraverseToFile(Node<T> local) {
        List<T> temp = new ArrayList<>();
        if (local != null) {
            temp.addAll(inOrderTraverseToFile(local.getLeft()));
            temp.add(local.getData());
            temp.addAll(inOrderTraverseToFile(local.getRight()));
        }
        return temp;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

}
