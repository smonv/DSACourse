package controllers;

import entity.TaxPayer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import list.LinkedList;

public class FileController {

    private static String taxPayerFile = "TaxPayers.txt";

    public LinkedList readData() {
        LinkedList taxPayers = new LinkedList();
        try {
            File f = new File(taxPayerFile);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] infos = line.split("\\|");
                String code = infos[0].trim();
                String name = infos[1].trim();
                Double income = Double.parseDouble(infos[2].trim());
                Double deduct = Double.parseDouble(infos[3].trim());
                Double tax = Double.parseDouble(infos[4].trim());

                TaxPayer tp = new TaxPayer(code, name, income, deduct, tax);
                taxPayers.add(tp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return taxPayers;
    }

}
