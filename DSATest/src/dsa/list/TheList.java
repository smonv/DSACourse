package dsa.list;

import dsa.entity.Student;
import java.util.Date;

public class TheList {

    private Node head, tail;
    private int size;

    public TheList() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int id, String name, Date dob) {
        Student s = new Student(id, name, dob);
        Node n = new Node(s, null);
        if (head == null) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
        size++;
    }

    public void addMany(int[] id, String[] name, Date[] dob, int n) {
        for (int i = 0; i < n; i++) {
            add(id[i], name[i], dob[i]);
        }
    }

    public void displayAll() {
        Node n = this.head;
        while (n != null) {
            System.out.println(n.getInfo());
            n = n.getNext();
        }
    }

    public void deleLast() throws Exception {
        if(isEmpty()){
            throw new Exception("No Item in List");
        }
        Node n = this.head;
        while (n != null) {
            Node next = n.getNext();
            if (next.getNext() == null) {
                n.setNext(null);
                tail = n;
                size--;
                break;
            } else {
                n = n.getNext();
            }
        }
    }

    public void deleFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("No Item in List");
        }
        Node n = this.head.getNext();
        head = n;
        size--;
    }

    public Student searchByName(String name) {
        Node n = this.head;
        while (n != null) {
            if (name.equals(n.getInfo().getName())) {
                return n.getInfo();
            } else {
                n = n.getNext();
            }
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    // Get and Set
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
