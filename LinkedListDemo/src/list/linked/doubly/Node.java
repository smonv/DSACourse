package list.linked.doubly;

public class Node {
   int info;
    Node next, prev;

    public Node(int info, Node next, Node prev){
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    public Node(int info){
        this(info, null, null);
    }
}

