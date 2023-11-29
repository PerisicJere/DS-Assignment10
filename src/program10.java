import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class program10 {
    public static void main(String[] args) {
        String file = "car_sales_data.csv";
        TreeMap<String, ArrayList<SaleRecord>> treeMap = new TreeMap<>();
        long startTime = System.currentTimeMillis();
        insertFromCSV(file, treeMap);
        long endTime = System.currentTimeMillis();
        System.out.println((float)(endTime-startTime)/1000+" seconds");
        int count = 0;
        for (Map.Entry<String, ArrayList<SaleRecord>> entry : treeMap.entrySet()) {
            System.out.println("Car Make: " + entry.getKey());
            for (SaleRecord saleRecord : entry.getValue()) {
                count++;
            }
            System.out.print(" "+count);
            count = 0;
            System.out.println();
        }
    }
    private static SaleRecord parsingCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length != 9) {
            return null;
        }
        String dateStr = parts[0];
        String salesperson = parts[1];
        String customerName = parts[2];
        String carMake = parts[3];
        String carModel = parts[4];
        int carYear = Integer.parseInt(parts[5]);
        double salePrice = Double.parseDouble(parts[6]);
        double commissionRate = Double.parseDouble(parts[7]);
        double commissionEarned = Double.parseDouble(parts[8]);

        return new SaleRecord(dateStr, salesperson, customerName, carMake, carModel, carYear, salePrice, commissionRate, commissionEarned);
    }
    private static void insertFromCSV(String csvFilePath, TreeMap<String, ArrayList<SaleRecord>> treeMap ){
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            boolean skipHeader = true;
            while ((line = reader.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                SaleRecord saleRecord = parsingCSV(line);
                if (saleRecord != null) {
                    String carMake = saleRecord.getCarMake();
                    ArrayList<SaleRecord> arrayList = treeMap.get(carMake);

                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                        treeMap.put(carMake, arrayList);
                    }

                    arrayList.add(saleRecord);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}