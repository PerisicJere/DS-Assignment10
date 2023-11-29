import java.io.*;
import java.util.*;

public class program10 {
    public static void main(String[] args) {
        String file = "small_sample.csv";
        TreeMap<String, ArrayList<SaleRecord>> treeMap = new TreeMap<>();
        long startTime = System.currentTimeMillis();
        insertFromCSV(file, treeMap);
        experiment1(treeMap);

    }
    public static void experiment1(TreeMap<String, ArrayList<SaleRecord>> treeMap){
        System.out.print("Unsorted list: ");
        ArrayList<SaleRecord> tries = new ArrayList<>();
        for (Map.Entry<String, ArrayList<SaleRecord>> entry : treeMap.entrySet()) {
            tries.addAll(entry.getValue());
        }
        System.out.println();
        QuickSort quickSort = new QuickSort(tries,1);
        System.out.print("Sorted list: ");
        for(SaleRecord num : tries){
            System.out.print(num+", ");
        }
    }
    private static SaleRecord parsingCSV(String line) {
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
                populateTreeMap(saleRecord, treeMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void populateTreeMap(SaleRecord saleRecord, TreeMap<String, ArrayList<SaleRecord>> treeMap){
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
}