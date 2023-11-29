import java.io.*;
import java.util.*;

public class program10 {
    public static void main(String[] args) {
        String file = "car_sales_data.csv";
        TreeMap<String, ArrayList<SaleRecord>> treeMap = new TreeMap<>();
        insertFromCSV(file, treeMap);
        experiment(treeMap,1);
        experiment(treeMap,2);
        experiment(treeMap,3);
        experiment(treeMap,4);

    }
    public static void experiment(TreeMap<String, ArrayList<SaleRecord>> treeMap, int partitionNum){
        System.out.println("Partitioning with x[bot]: ");

        for (Map.Entry<String, ArrayList<SaleRecord>> entry : treeMap.entrySet()) {
            ArrayList<SaleRecord> tries = entry.getValue();
            System.out.print(entry.getKey() + ":");
            int count = 0;
            long startTime = System.currentTimeMillis();
            QuickSort quickSort = new QuickSort(tries, partitionNum);
            long endTime = System.currentTimeMillis();
            float finalTime = (float) (endTime - startTime) / 1000;
            count += tries.size();
            System.out.printf(count + " records\t" + finalTime + " seconds\n");

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