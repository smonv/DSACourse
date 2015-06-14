package list;

public class LinkedList<E> {

    private Node<E> first, last;
    private int size;

    public LinkedList() {
        first = last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(E e) {
        linkLast(e);
    }

    public void addFirst(E e) {
        linkFirst(e);
    }

    public void addLast(E e) {
        linkLast(e);
    }

    public void linkFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    public void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public E getFirst() {
        return first.item;
    }

    public void setFirst(E e) {
        linkFirst(e);
    }

    public E getLast() {
        return last.item;
    }

    public void setLast(E e) {
        linkLast(e);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private static class Node<E> {

        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
