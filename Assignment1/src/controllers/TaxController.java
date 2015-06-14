package controllers;

import entity.TaxPayer;
import list.LinkedList;

public class TaxController {

    public boolean add(TaxPayer tp, LinkedList taxPayers) {
        String[] infos = new String[5];
        infos[0] = tp.getCode();
        infos[1] = tp.getName();
        infos[2] = Double.toString(tp.getIncome());
        infos[3] = Double.toString(tp.getDeduct());
        infos[4] = Double.toString(tp.getTax());

        FileController fc = new FileController();
        if (fc.writeData(infos)) {
            taxPayers.add(tp);
            return true;
        }
        return false;
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

    public String generateTaxPayerCode(LinkedList<TaxPayer> taxPayers) {
        TaxPayer tp = taxPayers.getLast();
        int lastCode = Integer.parseInt(tp.getCode());
        String code = Integer.toString(++lastCode);
        return code;
    }

}
