package controllers;

import entity.TaxPayer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import tree.AVLTree;

public class FileController {

    private static String taxPayerFile = "TaxPayers.txt";

    public AVLTree<TaxPayer> loadData() throws IOException {
        AVLTree<TaxPayer> taxPayers = new AVLTree<>();
        File inFile = new File(taxPayerFile);
        if (!inFile.exists()) {
            return taxPayers;
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(inFile));
            String line;
            while ((line = br.readLine()) != null) {
                String[] infos = line.split("\\|");
                String code = infos[0].trim();
                String name = infos[1].trim();
                Double income = Double.parseDouble(infos[2].trim());
                Double deduct = Double.parseDouble(infos[3].trim());
                Double tax = Double.parseDouble(infos[4].trim());

                TaxPayer tp = new TaxPayer(code, name, income, deduct, tax);
                taxPayers.insert(tp);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return taxPayers;
    }

    public boolean saveData(AVLTree<TaxPayer> taxPayers) throws IOException {

        if (taxPayers == null || taxPayers.isEmpty()) {
            return false;
        }

        File inFile = new File(taxPayerFile);

        if (inFile.exists()) {
            if (!inFile.delete()) {
                return false;
            }
        }
        File newFile = new File(taxPayerFile);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(newFile, true));
            List<TaxPayer> temp = taxPayers.inOrderTraverseToFile(taxPayers.getRoot());
            for (TaxPayer tp : temp) {
                String[] info = {
                    tp.getCode(),
                    tp.getName(),
                    Double.toString(tp.getIncome()),
                    Double.toString(tp.getDeduct()),
                    Double.toString(tp.getTax())
                };

                String line = String.join(" | ", info);
                bw.append(line);
                bw.newLine();
                bw.flush();
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
        return newFile.getUsableSpace() > 0;
    }
}
