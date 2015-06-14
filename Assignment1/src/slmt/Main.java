package slmt;

import controllers.FileController;
import controllers.TaxController;
import entity.ModifiedTaxPayer;
import entity.TaxPayer;
import java.util.Scanner;
import list.LinkedList;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        LinkedList<TaxPayer> taxPayers = new LinkedList<>();
        LinkedList<ModifiedTaxPayer> modifiedTaxPayers = new LinkedList<>();
        FileController fc = new FileController();
        TaxController tc = new TaxController();
        while (flag) {
            printMenu();
            String s = sc.nextLine();
            int selection = Integer.parseInt(s.trim());
            switch (selection) {
                case 1:
                    taxPayers = fc.loadData();
                    System.out.println(taxPayers.getSize() + " rows.");
                    System.out.println("Data loaded!");
                    break;
                case 2:
                    if (taxPayers.isEmpty()) {
                        taxPayers = fc.loadData();
                    }
                    TaxPayer tp = input(sc, tc, taxPayers);
                    tc.add(tp, taxPayers, modifiedTaxPayers);
                    System.out.println("New tax payers added!");
                    break;
                case 3:
                    if (taxPayers.isEmpty()) {
                        taxPayers = fc.loadData();
                    }
                    taxPayers.traverse();
                    break;
                case 4:
                    if (taxPayers.isEmpty()) {
                        taxPayers = fc.loadData();
                    }
                    boolean result = tc.saveDataToFile(modifiedTaxPayers);
                    if (result) {
                        System.out.println("Data saved to file!");
                    } else {
                        System.out.println("Failed to save data to file!");
                    }
                    break;
                case 5:
                    if (taxPayers.isEmpty()) {
                        taxPayers = fc.loadData();
                    }
                    System.out.println("Enter tax payer code: ");
                    String searchCode = sc.nextLine();
                    TaxPayer tpSearch = tc.search(searchCode, taxPayers);
                    System.out.println(tpSearch);
                    break;
                case 6:
                    if (taxPayers.isEmpty()) {
                        taxPayers = fc.loadData();
                    }
                    System.out.println("Enter tax payer code: ");
                    String removeCode = sc.nextLine();
                    tc.remove(removeCode, taxPayers, modifiedTaxPayers);
                    break;
                case 0:
                    if (modifiedTaxPayers.isEmpty()) {
                    } else {
                        System.out.println("Data modified but not save! Confirm exit(Y/N): ");
                        String confirm = sc.nextLine();
                        flag = !confirm.equals("Y");
                    }
                    if (!flag) {
                        System.out.println("Program exiting...! Bye");
                    } else {
                        System.out.println("Use option 4 to save data!");
                    }
                    break;
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

    public static TaxPayer input(Scanner sc, TaxController tc, LinkedList<TaxPayer> taxPayers) {
        System.out.println("Enter tax payer infomations: ");
        System.out.println("Enter Code: ");
        String code = sc.nextLine();
        System.out.println("Enter Name: ");
        String name = sc.nextLine().trim();
        System.out.println("Enter Income: ");
        Double income = Double.parseDouble(sc.nextLine().trim());
        System.out.println("Enter Deduct: ");
        Double deduct = Double.parseDouble(sc.nextLine().trim());

        Double tax = tc.countTax(income, deduct);

        TaxPayer tp = new TaxPayer(code, name, income, deduct, tax);
        return tp;
    }

    public static void loadData(LinkedList taxPayers, FileController fc) {

    }
}
