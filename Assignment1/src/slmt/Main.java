package slmt;

import entity.TaxPayer;
import list.LinkedList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        while (flag) {
            printMenu();
            String s = sc.nextLine();
            int selection = Integer.parseInt(s.trim());
            switch (selection) {
                case 0:
                    System.out.println("Program exiting...! Bye");
                    flag = false;
            }
        }

        TaxPayer tp = new TaxPayer("GC00556", "SolomonT", 1111, 123, 15);
        LinkedList<TaxPayer> taxPayers = new LinkedList<>();
        taxPayers.add(tp);
    }

    public static void printMenu() {
        System.out.println("1. Load data from file");
        System.out.println("2. Input & add to end");
        System.out.println("3. Display data");
        System.out.println("4. Save data to file");
        System.out.println("5. Search by code");
        System.out.println("6. Delete by code");
        System.out.println("7. Sort by code");
        System.out.println("8. Input & add to begining");
        System.out.println("9. Add after position k");
        System.out.println("10. Delete after position k");
        System.out.println("0. Exit");
        System.out.println("Your selection (0 -> 10):");
    }
}