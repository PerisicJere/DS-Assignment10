import java.io.*;
import java.text.ParseException;

import java.util.*;

public class program10 {
    public static void main(String[] args) {
        String file = "car_sales_data.csv";
        TreeMap<String, ArrayList<SaleRecord>> treeMap = new TreeMap<>();
        long startTime = System.currentTimeMillis();
        insertFromCSV(file, treeMap);
        long endTime = System.currentTimeMillis();
        System.out.println((float)(endTime-startTime)/1000+" seconds");
        System.out.print("Unsorted list: ");


    }
    private static SaleRecord parsingCSV(String line) throws ParseException {
        String[] parts = line.split(",");
        if (parts.length != 9) {
            return null;
        }
        String date = parts[0];
        String carMake = parts[3];


        return new SaleRecord(date, carMake);
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

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}