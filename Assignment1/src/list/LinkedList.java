package list;

import entity.TaxPayer;

public class LinkedList {

    public Node first, last;
    private int size;

    public LinkedList() {
        first = last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(TaxPayer tp) {
        linkLast(tp);
    }

    public void addFirst(TaxPayer tp) {
        linkFirst(tp);
    }

    public void addLast(TaxPayer tp) {
        linkLast(tp);
    }

    public void linkFirst(TaxPayer tp) {
        Node f = first;
        Node newNode = new Node(null, tp, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    public void linkLast(TaxPayer tp) {
        Node l = last;
        Node newNode = new Node(l, tp, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public void traverse() {
        Node n = first;
        while (n != null) {
            System.out.println(n.getTaxPayer().getCode() + " " + n.getTaxPayer().getName());
            n = n.getNext();
        }
    }

    private static class Node {

        private TaxPayer taxPayer;
        private Node next;
        private Node prev;

        Node(Node prev, TaxPayer taxPayer, Node next) {
            this.taxPayer = taxPayer;
            this.next = next;
            this.prev = prev;
        }

        public TaxPayer getTaxPayer() {
            return taxPayer;
        }

        public void setTaxPayer(TaxPayer taxPayer) {
            this.taxPayer = taxPayer;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

    }
}
