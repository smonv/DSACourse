package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkedList<T extends Comparable<T>> implements Comparable<Node<T>> {

    private Node<T> first, last;
    private int size;

    public LinkedList() {
        first = last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T data) {
        linkLast(data);
    }

    public void addFirst(T data) {
        linkFirst(data);
    }

    public void addLast(T data) {
        linkLast(data);
    }

    public void addAfter(T data, Node<T> node) {
        linkAfter(data, node);
    }

    public void addAfter(T data, int position) {
        addAfter(data, elementAt(position));
    }

    public void linkFirst(T data) {
        Node<T> f = first;
        Node<T> newNode = new Node<>(null, data, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.setPrev(newNode);
        }
        size++;
    }

    public void linkLast(T data) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(l, data, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.setNext(newNode);
        }
        size++;
    }

    public void linkAfter(T data, Node<T> node) {
        Node<T> after = node.getNext();
        Node<T> newNode = new Node<>(node, data, after);
        node.setNext(newNode);
        if (after != null) {
            after.setPrev(newNode);
        }
        size++;
    }

    public Node<T> searchNode(T data) {
        Node<T> n = this.first;
        while (n != null) {
            if (n.getData().compareTo(data) == 0) {
                return n;
            } else {
                n = n.getNext();
            }
        }
        return null;
    }

    public void remove(T data) {
        Node<T> n = searchNode(data);
        if (n == first) {
            removeFirst();
        } else if (n == last) {
            removeLast();
        } else {
            Node<T> currentNext = n.getNext();
            Node<T> currentPrev = n.getPrev();
            currentPrev.setNext(currentNext);
            currentNext.setPrev(currentPrev);
            size--;
        }
    }

    public void removeFirst() {
        Node<T> n = first.getNext();
        n.setPrev(null);
        first.setNext(null);
        first = n;
        size--;
    }

    public void removeLast() {
        Node<T> n = last.getPrev();
        n.setNext(null);
        last.setPrev(null);
        last = n;
        size--;
    }

    public void removeAfter(int position) {
        remove(elementAt(position).getData());
    }

    public void removeAll() {
        first = last = null;
        size = 0;
    }

    public void traverse() {
        Node<T> n = first;
        while (n != null) {
            System.out.println(n.getData().toString());
            n = n.getNext();
        }
    }

    public T search(T data) {
        Node<T> node = this.first;
        while (node != null) {
            if (node.getData().compareTo(data) == 0) {
                return node.getData();
            } else {
                node = node.getNext();
            }
        }
        return null;
    }

    public Node<T> elementAt(int k) {
        if (k > size - 1) {
            return null;
        }
        Node<T> n = first;
        int i = 0;
        while (n != null) {
            if (i == k) {
                return n;
            } else {
                n = n.getNext();
                i++;
            }
        }
        return null;
    }

    public LinkedList<T> sort() {
        List<T> temp = new ArrayList<>();
        Node<T> n = this.first;
        while (n != null) {
            temp.add(n.getData());
            n = n.getNext();
        }
        Collections.sort(temp);
        LinkedList<T> newTemp = new LinkedList<>();

        for (T t : temp) {
            newTemp.add(t);
        }

        return newTemp;
    }

    public Node<T> getNodeFirst() {
        return first;
    }

    public Node<T> getNodeLast() {
        return last;
    }

    @Override
    public int compareTo(Node<T> o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T getFirst() {
        return first.getData();
    }

    public void setFirst(T first) {
        this.first.setData(first);
    }

    public T getLast() {
        return last.getData();
    }

    public void setLast(T last) {
        this.last.setData(last);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
