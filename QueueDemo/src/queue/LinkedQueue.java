package queue;

public class LinkedQueue {
    private Node head, tail;

    public LinkedQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(Object x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }

    public Object front() {
        if (isEmpty()) return null;
        return head.info;
    }

    public Object dequeue() {
        if (isEmpty()) return null;
        Object x = head.info;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return x;
    }
}
