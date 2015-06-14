package controllers;

import entity.TaxPayer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import list.LinkedList;

public class FileController {

    private static String taxPayerFile = "TaxPayers.txt";

    public LinkedList loadData() {
        LinkedList taxPayers = new LinkedList();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(taxPayerFile)));
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
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }

        return taxPayers;
    }

    public boolean writeData(String[] infos) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(taxPayerFile, true));
            bw.append(String.join(" | ", infos));
            bw.newLine();
            bw.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (Exception e) {
                }
            }
        }

    }

}
