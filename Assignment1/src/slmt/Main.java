package slmt;

import controllers.FileController;
import controllers.TaxController;
import entity.TaxPayer;
import java.io.IOException;
import java.util.Scanner;
import list.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        FileController fc = new FileController();
        TaxController tc = new TaxController();
        LinkedList<TaxPayer> taxPayers = fc.loadData();
        int taxPayersDefaultSize = taxPayers.getSize();

        while (flag) {
            printMenu();
            String s = sc.nextLine();
            if (!"".equals(s)) {
                int selection = Integer.parseInt(s.trim());
                switch (selection) {
                    case 1:
                        taxPayers = fc.loadData();
                        taxPayersDefaultSize = taxPayers.getSize();
                        System.out.println("Loaded " + taxPayers.getSize() + " rows.");
                        break;

                    case 2:
                        TaxPayer newTaxPayer = input(sc, tc);
                        taxPayers.add(newTaxPayer);
                        System.out.println("New tax payers added!");
                        break;

                    case 3:
                        taxPayers.traverse();
                        break;

                    case 4:
                        taxPayers = taxPayers.sort();
                        boolean result = fc.saveData(taxPayers);
                        if (result) {
                            taxPayersDefaultSize = taxPayers.getSize();
                        }
                        String msg = result ? "Data saved to file!" : "Failed to save data to file!";
                        System.out.println(msg);
                        break;

                    case 5:
                        System.out.println("Enter tax payer code: ");
                        String searchCode = sc.nextLine();
                        TaxPayer tpSearch = taxPayers.search(new TaxPayer(searchCode));
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
                        taxPayers.remove(new TaxPayer(removeCode));
                        break;

                    case 7:
                        taxPayers = taxPayers.sort();
                        taxPayers.traverse();
                        break;

                    case 8:
                        TaxPayer newTaxPayerFirst = input(sc, tc);
                        taxPayers.addFirst(newTaxPayerFirst);
                        System.out.println("New tax payer added!");
                        break;

                    case 9:
                        System.out.println("Enter position k (number): ");
                        int kAdd = Integer.parseInt(sc.nextLine());
                        if (kAdd < taxPayers.getSize()) {
                            TaxPayer newTaxPayerAfter = input(sc, tc);
                            taxPayers.addAfter(newTaxPayerAfter, kAdd);
                            System.out.println("New tax payer added!");
                        } else {
                            System.out.println("Invalid position!");
                        }
                        break;

                    case 10:
                        System.out.println("Enter position k (number): ");
                        int kDel = Integer.parseInt(sc.nextLine());
                        if (kDel < taxPayers.getSize()) {
                            taxPayers.removeAfter(kDel);
                            System.out.println("Tax payer deleted!");
                        } else {
                            System.out.println("Invalid position!");
                        }
                        break;

                    case 0:
                        if (taxPayersDefaultSize != taxPayers.getSize()) {
                            System.out.println("Data modified but not save! Confirm exit(Y/N): ");
                            String confirm = sc.nextLine();
                            if ("Y".equals(confirm)) {
                                fc.saveData(taxPayers);
                            } else {
                                flag = !confirm.equals("Y");
                            }
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
            } else {
                System.out.println("Please enter an option number!");
                System.out.println("------------------------------");
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
}
