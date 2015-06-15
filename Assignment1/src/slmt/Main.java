package slmt;

import controllers.FileController;
import controllers.TaxController;
import entity.ModifiedTaxPayer;
import entity.TaxPayer;
import java.io.IOException;
import java.util.Scanner;
import list.LinkedList;
import list.Node;

public class Main {

    public static void main(String[] args) throws IOException {
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
                    TaxPayer newTaxPayer = input(sc, tc);
                    tc.add(newTaxPayer, taxPayers, modifiedTaxPayers);
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
                    boolean result = tc.saveDataToFile(taxPayers);
                    if (result) {
                        modifiedTaxPayers.removeAll();
                    }
                    String msg = result ? "Data saved to file!" : "Failed to save data to file!";
                    System.out.println(msg);
                    break;

                case 5:
                    if (taxPayers.isEmpty()) {
                        taxPayers = fc.loadData();
                    }
                    System.out.println("Enter tax payer code: ");
                    String searchCode = sc.nextLine();
                    TaxPayer tpSearch = tc.search(searchCode, taxPayers);
                    if (tpSearch != null) {
                        System.out.println(tpSearch);
                    } else {
                        System.out.println("No result found!");
                    }
                    break;

                case 6:
                    if (taxPayers.isEmpty()) {
                        taxPayers = fc.loadData();
                    }
                    System.out.println("Enter tax payer code: ");
                    String removeCode = sc.nextLine();
                    tc.remove(removeCode, taxPayers, modifiedTaxPayers);
                    break;

                case 7:
                    break;

                case 8:
                    loadData(taxPayers, fc);
                    TaxPayer newTaxPayerFirst = input(sc, tc);
                    tc.addFirst(newTaxPayerFirst, taxPayers, modifiedTaxPayers);
                    System.out.println("New tax payer added!");
                    break;

                case 9:
                    loadData(taxPayers, fc);
                    System.out.println("Enter position k (number): ");
                    int k = Integer.parseInt(sc.nextLine());
                    if (k < taxPayers.getSize()) {
                        Node<TaxPayer> nodePosition = tc.searchPosition(k, taxPayers);
                        TaxPayer newTaxPayerAfter = input(sc, tc);
                        tc.addAfter(newTaxPayerAfter, nodePosition, taxPayers, modifiedTaxPayers);
                        System.out.println("New tax payer added!");
                    } else {
                        System.out.println("Position k is not valid!");
                    }
                    break;

                case 10:
                    break;

                case 0:
                    if (!modifiedTaxPayers.isEmpty()) {
                        System.out.println("Data modified but not save! Confirm exit(Y/N): ");
                        String confirm = sc.nextLine();
                        flag = !confirm.equals("Y");
                    } else {
                        flag = false;
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

    public static TaxPayer input(Scanner sc, TaxController tc) {
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

    public static void loadData(LinkedList<TaxPayer> taxPayers, FileController fc) throws IOException {
        if (taxPayers.isEmpty()) {
            taxPayers = fc.loadData();
        }
    }
}
