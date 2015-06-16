package controllers;

import entity.ModifiedTaxPayer;
import entity.TaxPayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import list.LinkedList;
import list.Node;

public class TaxController {

    FileController fc = new FileController();

    public void add(TaxPayer tp, LinkedList<TaxPayer> taxPayers, LinkedList<ModifiedTaxPayer> modifiedTaxPayers) {
        taxPayers.add(tp);
        modifiedTaxPayers.add(new ModifiedTaxPayer(tp, true));
    }

    public void addFirst(TaxPayer tp, LinkedList<TaxPayer> taxPayers, LinkedList<ModifiedTaxPayer> modifiedTaxPayers) {
        taxPayers.addFirst(tp);
        modifiedTaxPayers.add(new ModifiedTaxPayer(tp, true));
    }

    public void addAfter(TaxPayer tp, Node<TaxPayer> node, LinkedList<TaxPayer> taxPayers, LinkedList<ModifiedTaxPayer> modifiedTaxPayers) {
        taxPayers.addAfter(tp, node);
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

    public void removePosition(Node<TaxPayer> position, LinkedList<TaxPayer> taxPayers, LinkedList<ModifiedTaxPayer> modifiedTaxPayers) {
        taxPayers.remove(position);
        modifiedTaxPayers.add(new ModifiedTaxPayer(position.getItem(), false));
    }

    public LinkedList<TaxPayer> sort(LinkedList<TaxPayer> taxPayers) {
        List<TaxPayer> tmpTaxPayers = new ArrayList<>();
        Node<TaxPayer> n = taxPayers.getNodeFirst();
        while (n != null) {
            tmpTaxPayers.add(n.getItem());
            n = n.getNext();
        }
        Collections.sort(tmpTaxPayers);
        LinkedList<TaxPayer> newTaxPayers = new LinkedList<>();
        
        for (TaxPayer tp : tmpTaxPayers) {
            newTaxPayers.add(tp);
        }

        return newTaxPayers;
    }

    public boolean saveDataToFile(LinkedList<TaxPayer> taxPayers) throws IOException {
        return fc.saveData(taxPayers);
    }
}
