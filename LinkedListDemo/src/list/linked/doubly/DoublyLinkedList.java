package list.linked.doubly;

public class DoublyLinkedList {
    Node head, tail;

    public DoublyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            Node n = new Node(x, null, tail);
            tail.next = n;
            tail = n;
        }
    }

    public void addMany(int[] a) {
        for (int i : a) {
            add(i);
        }
    }

    public void traverse() {
        Node n = head;
        while (n != null) {
            System.out.println(n.info);
            n = n.next;
        }
    }

    public void addHead(int x) {
        Node n = new Node(x);
        n.next = head;
        head.prev = n;
        head = n;
    }

    public void addTail(int x) {
        Node n = new Node(x);
        n.prev = tail;
        tail.next = n;
        tail = n;
    }

    public void removeHead() {
        Node n = head.next;
        n.prev = null;
        head.next = null;
        head = n;
    }

    public void removeTail(){
        Node n = tail.prev;
        n.next = null;
        tail.prev = null;
        tail = n;
    }
}
