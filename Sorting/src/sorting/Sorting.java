package sorting;

public class Sorting {

    public static void main(String[] args) {
        int[] a = {10, 4, 20, 9, 11, 15, 45, 16, 94, 52, 33};
        SortAlgorithms sa = new SortAlgorithms();
        
//        sa.selectionSort(a);
//        sa.insertionSort(a);
//        sa.bubbleSort(a);
//        sa.shellSort(a);
        sa.quickSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

}
