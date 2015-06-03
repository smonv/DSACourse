package stack;
import java.util.ArrayList;

public class ArrayListStack {
    ArrayList a;
    public ArrayListStack(){
        a = new ArrayList();
    }

    public boolean isEmpty(){
        return a.isEmpty();
    }

    public void push(Object x){
        a.add(x);
    }

    public Object pop(){
        if(isEmpty()) return null;
        return a.remove(a.size() - 1);
    }
}
