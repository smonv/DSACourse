package stack;

public class ArrayStackImp {
    public static void main(String[] args) {
        decToBin(123456789);
    }

    public static void decToBin(int k) {
        ArrayStack as = new ArrayStack();
        System.out.println(k + " in binary system is: ");
        while (k > 0) {
            as.push(new Integer(k % 2));
            k = k / 2;
        }
        while(!as.isEmpty()){
            System.out.println(as.pop());
        }
        System.out.println("");
    }
}
