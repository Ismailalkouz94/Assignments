package com.company;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FinancialTransactionsProcessor {
    private static final String FILENAME = "/home/ismail/Downloads/transactions.txt";
    private Map<String, BigDecimal> acountTransationMap = new HashMap<String, BigDecimal>();

    public void readTransaction() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))) {


            String transactionLine[];
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                transactionLine = line.split(",");

                checkAcount(transactionLine[0]);
                storeAmount(transactionLine);
            }

            displayResult();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkAcount(String acountNo) {
        if (!acountTransationMap.containsKey(acountNo)) {
            acountTransationMap.put(acountNo, new BigDecimal(0));
        }
    }

    private void storeAmount(String transactionLine[]) {
        BigDecimal newAmount = new BigDecimal(transactionLine[2]);
        if (transactionLine[1].equals("C")) {
            newAmount = acountTransationMap.get(transactionLine[0]).add(newAmount);
        } else if (transactionLine[1].equals("D")) {
            newAmount = acountTransationMap.get(transactionLine[0]).subtract(newAmount);
        }
        acountTransationMap.put(transactionLine[0], newAmount);
    }

    public void displayResult() {
        for (Map.Entry<String, BigDecimal> entry : acountTransationMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
