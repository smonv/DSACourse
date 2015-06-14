package controllers;

import entity.ModifiedTaxPayer;
import entity.TaxPayer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import list.LinkedList;
import list.Node;

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

    public boolean saveData(LinkedList<ModifiedTaxPayer> modifiedTaxPayers, TaxController tc) {
        boolean result = false;
        result = removeData(tc.getRemovedTaxPayers(modifiedTaxPayers));
        result = addData(tc.getAddedTaxPayers(modifiedTaxPayers));
        return true;
    }

    public boolean removeData(LinkedList<ModifiedTaxPayer> removedTaxPayers) {
        if (removedTaxPayers.isEmpty()) {
            return true;
        }
        File taxPayersFile = new File(taxPayerFile);
        File tmp = new File("TaxPayers.tmp");
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(taxPayersFile));
            bw = new BufferedWriter(new FileWriter(tmp, true));
            String line;
            while ((line = br.readLine()) != null) {
                Node<ModifiedTaxPayer> n = removedTaxPayers.getNodeFirst();
                while (n != null) {
                    if (!n.getItem().getTp().getCode().equals(line.split("\\|")[0].trim())) {
                        bw.append(String.join(" | ", line.split("\\|")));
                        bw.newLine();
                        bw.flush();
                    }
                }
            }
            taxPayersFile.delete();
            tmp.renameTo(new File(taxPayerFile));

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }

            if (bw != null) {
                try {
                    bw.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public boolean addData(LinkedList<ModifiedTaxPayer> addedTaxPayers) {
        if (addedTaxPayers.isEmpty()) {
            return true;
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(taxPayerFile, true));
            Node<ModifiedTaxPayer> n = addedTaxPayers.getNodeFirst();
            while (n != null) {
                TaxPayer tp = n.getItem().getTp();
                String[] infos = new String[5];
                infos[0] = tp.getCode();
                infos[1] = tp.getName();
                infos[2] = Double.toString(tp.getIncome());
                infos[3] = Double.toString(tp.getDeduct());
                infos[4] = Double.toString(tp.getTax());
                bw.append(String.join(" | ", infos));
                bw.flush();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
