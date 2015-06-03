package stack;

import java.util.LinkedList;

public class LinkedListStack {
    LinkedList ll;

    public LinkedListStack() {
        ll = new LinkedList();
    }

    public boolean isEmpty(){
        return ll.isEmpty();
    }

    public void push(Object x){
        ll.addLast(x);
    }

    public Object pop(){
        if(isEmpty()) return null;
        return ll.removeLast();
    }
}
