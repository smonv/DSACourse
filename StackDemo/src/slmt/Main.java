package slmt;

import stack.ArrayListStack;
import stack.ArrayStack;
import stack.LinkedListStack;

public class Main {

    public static void main(String[] args) {
        //ArrayStack as = new ArrayStack();
        //ArrayListStack as = new ArrayListStack();
        LinkedListStack as = new LinkedListStack();
        as.push("test1");
        as.push("test2");

        String x = (String) as.pop();
        System.out.println(x);
        x = (String) as.pop();
        System.out.println(x);
    }
}
