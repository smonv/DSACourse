package slmt;

import controllers.FileController;
import controllers.TaxController;
import entity.TaxPayer;
import java.util.Scanner;
import list.LinkedList;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        LinkedList taxPayers = new LinkedList();
        FileController fc = new FileController();
        TaxController tc = new TaxController();
        while (flag) {
            printMenu();
            String s = sc.nextLine();
            int selection = Integer.parseInt(s.trim());
            switch (selection) {
                case 1:
                    taxPayers = fc.loadData();
                    System.out.println("Data loaded!");
                case 2:
                    if (taxPayers.isEmpty()) {
                        taxPayers = fc.loadData();
                    }

                    TaxPayer tp = input(sc, tc, taxPayers);
                    tc.add(tp, taxPayers);
                    System.out.println("New tax payers added");
                case 0:
                    System.out.println("Program exiting...! Bye");
                    flag = false;
            }
        }
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

    public static TaxPayer input(Scanner sc, TaxController tc, LinkedList taxPayers) {
        System.out.println("Enter tax payer infomations: ");
        System.out.println("Enter Name: ");
        String name = sc.nextLine().trim();
        System.out.println("Enter Income: ");
        Double income = Double.parseDouble(sc.nextLine().trim());
        System.out.println("Enter Deduct: ");
        Double deduct = Double.parseDouble(sc.nextLine().trim());

        String code = tc.generateTaxPayerCode(taxPayers);
        Double tax = tc.countTax(income, deduct);

        TaxPayer tp = new TaxPayer(code, name, income, deduct, tax);
        return tp;
    }

    public static void loadData(LinkedList taxPayers, FileController fc) {

    }
}
