package controllers;

import entity.ModifiedTaxPayer;
import entity.TaxPayer;
import java.io.IOException;
import list.LinkedList;
import list.Node;

public class TaxController {

    FileController fc = new FileController();

    public void add(TaxPayer tp, LinkedList<TaxPayer> taxPayers, LinkedList<ModifiedTaxPayer> modifiedTaxPayers) {
        String[] infos = new String[5];
        infos[0] = tp.getCode();
        infos[1] = tp.getName();
        infos[2] = Double.toString(tp.getIncome());
        infos[3] = Double.toString(tp.getDeduct());
        infos[4] = Double.toString(tp.getTax());

        taxPayers.add(tp);
        modifiedTaxPayers.add(new ModifiedTaxPayer(tp, true));
    }

    public Double countTax(Double income, Double deduct) {
        income -= deduct;
        Double tax = Double.MIN_NORMAL;
        if (income <= 5000) {
            tax = income * 0.05;
        } else if (income > 5000 && income <= 10000) {
            tax = income * 0.1;
        } else if (income > 10000) {
            tax = income * 0.15;
        }
        return tax;
    }

    public TaxPayer search(String code, LinkedList<TaxPayer> taxPayers) {
        Node<TaxPayer> n = taxPayers.getNodeFirst();
        while (n != null) {
            if (code.equals(n.getItem().getCode())) {
                return n.getItem();
            } else {
                n = n.getNext();
            }
        }
        return null;
    }

    public Node<TaxPayer> searchNode(String code, LinkedList<TaxPayer> taxPayers) {
        Node<TaxPayer> n = taxPayers.getNodeFirst();
        while (n != null) {
            if (code.equals(n.getItem().getCode())) {
                return n;
            } else {
                n = n.getNext();
            }
        }
        return null;
    }

    public void remove(String code, LinkedList<TaxPayer> taxPayers, LinkedList<ModifiedTaxPayer> modifiedTaxPayers) {
        Node<TaxPayer> n = searchNode(code, taxPayers);
        if (n != null) {
            taxPayers.remove(n);
            modifiedTaxPayers.add(new ModifiedTaxPayer(n.getItem(), false));
        }
    }

    public boolean saveDataToFile(LinkedList<TaxPayer> taxPayers) throws IOException {
        return fc.saveData(taxPayers);
    }
}
