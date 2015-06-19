package slmt;

import controllers.FileController;
import controllers.TaxController;
import entity.TaxPayer;
import java.io.IOException;
import java.util.Scanner;
import tree.AVLTree;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        FileController fc = new FileController();
        TaxController tc = new TaxController();
        AVLTree<TaxPayer> taxPayers = fc.loadData();

        while (flag) {
            printMenu();
            String s = sc.nextLine();
            if (!"".equals(s)) {
                int selection = Integer.parseInt(s);
                switch (selection) {
                    case 1:
                        taxPayers = fc.loadData();
                        System.out.println("Data loaded!");
                        break;

                    case 2:
                        TaxPayer tp = input(sc, tc);
                        taxPayers.insert(tp);
                        break;

                    case 3:
                        break;

                    case 4:
                        break;

                    case 5:
                        taxPayers.breathFirstTraverse();
                        break;

                    case 7:
                        System.out.println("Enter tax payer code: ");
                        String code = sc.nextLine();
                        TaxPayer tpSearch = new TaxPayer(code);
                        TaxPayer tpResult = taxPayers.search(tpSearch).getData();
                        System.out.println(tpResult.toString());

                    case 9:
                        System.out.println("AVLTree is used, no need this function!");
                        break;
                    case 10:
                        System.out.println("Number of tax payers: " + taxPayers.count());
                        break;
                    case 0:
                        break;
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("1. Load data from file");
        System.out.println("2. Input & insert data");
        System.out.println("3. In-order traverse");
        System.out.println("4. Pre-order traverse");
        System.out.println("5. Breath-first traverse");
        System.out.println("6. In-order traverse to file");
        System.out.println("7. Search by code");
        System.out.println("8. Delete by code by copying");
        System.out.println("9. Simply balancing (bs tree)");
        System.out.println("10. Count number of tax payers");
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
