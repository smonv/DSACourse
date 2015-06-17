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

    public void addAfter(E e, Node<E> n) {
        linkAfter(e, n);
    }

    public void linkFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.setPrev(newNode);
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
            l.setNext(newNode);
        }
        size++;
    }

    public void linkAfter(E e, Node<E> n) {
        Node<E> after = n.getNext();
        Node<E> newNode = new Node<>(n, e, after);
        n.setNext(newNode);
        if (after != null) {
            after.setPrev(newNode);
        }
        size++;
    }

    public void remove(Node<E> n) {
        if (n == first) {
            removeFirst();
        } else if (n == last) {
            removeLast();
        } else {
            Node<E> currentNext = n.getNext();
            Node<E> currentPrev = n.getPrev();
            currentPrev.setNext(currentNext);
            currentNext.setPrev(currentPrev);
            size--;
        }
    }

    public void removeFirst() {
        Node<E> n = first.getNext();
        n.setPrev(null);
        first.setNext(null);
        first = n;
        size--;
    }

    public void removeLast() {
        Node<E> n = last.getPrev();
        n.setNext(null);
        last.setPrev(null);
        last = n;
        size--;
    }

    public void removeAll() {
        first = last = null;
        size = 0;
    }

    public void traverse() {
        Node<E> n = first;
        while (n != null) {
            System.out.println(n.getItem().toString());
            n = n.getNext();
        }
    }

    public Node<E> elementAt(int k) {
        if (k > size - 1) {
            return null;
        }
        Node<E> n = first;
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

    public E getFirst() {
        return first.getItem();
    }

    public void setFirst(E e) {
        linkFirst(e);
    }

    public E getLast() {
        return last.getItem();
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

    public Node<E> getNodeFirst() {
        return first;
    }

    public Node<E> getNodeLast() {
        return last;
    }
}
