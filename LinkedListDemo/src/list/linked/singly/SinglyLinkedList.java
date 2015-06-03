package list.linked.singly;

public class SinglyLinkedList {
    Node head, tail;

    public SinglyLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int x) {
        Node n = new Node(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public void addMany(int[] x) {
        for (int i : x) {
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
        head = n;
    }

    public void addTail(int x) {
        Node n = new Node(x);
        tail.next = n;
        tail = n;
    }

    public void removeHead() {
        Node n = head.next;
        head.next = null;
        head = n;
    }

    public void removeTail() {
        Node n = head;
        while (n.next != null) {
            Node p = n.next;
            if (p.next == null) {
                n.next = null;
                tail = n;
                break;
            }else{
                n = n.next;
            }
        }
    }
}
