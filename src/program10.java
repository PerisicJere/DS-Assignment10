import java.io.*;
import java.util.*;

/**
 * @author Jere Perisic
 * @version November 30, 2023
 *
 * Program 10 compares different partitions of quicksort and modified quicksort that uses inertion sort.
 */
public class program10 {
    public static void main(String[] args) {
        String file = args[0];
        TreeMap<String, ArrayList<SaleRecord>> treeMap = new TreeMap<>();
        insertFromCSV(file, treeMap);
        runExperiments(treeMap);
        experimentWithInsertionSort(treeMap);
    }

    /**
     * Method to run all the experiments
     *
     * @param treeMap string carMake, array list of sale record objects
     */
    public static void runExperiments(TreeMap<String, ArrayList<SaleRecord>> treeMap){
        System.out.println("Partitioning with x[bot]: ");
        experiment(treeMap,1);
        System.out.println("Partitioning with x[top]: ");
        experiment(treeMap,2);
        System.out.println("Partitioning with x[mid]: ");
        experiment(treeMap,3);
        System.out.println("Partitioning with median (x[bot], x[mid], x[top] : ");
        experiment(treeMap,4);
        System.out.println("Partitioning with random value: ");
        experiment(treeMap, 5);
        System.out.println("Partitioning with random median value: ");
        experiment(treeMap, 6);
    }

    /**
     * Experiment method, sorts array of specific carMake, records time, and prints number of records, and seconds to execute
     *
     * @param treeMap string carMake, array list of sale record objects
     * @param partitionNum which partition needs to be executed
     */
    public static void experiment(TreeMap<String, ArrayList<SaleRecord>> treeMap, int partitionNum){
        for (Map.Entry<String, ArrayList<SaleRecord>> entry : treeMap.entrySet()) {
            ArrayList<SaleRecord> tries = entry.getValue();
            System.out.print(entry.getKey() + ": ");
            int count = 0;
            long startTime = System.currentTimeMillis();
            QuickSort quickSort = new QuickSort(tries, partitionNum);
            long endTime = System.currentTimeMillis();
            float finalTime = (float) (endTime - startTime) / 1000;
            count += tries.size();
            System.out.printf(count + " records\t " + finalTime + " seconds\n");

        }
    }

    /**
     * Second experiment method, sorts array list of specific carMake, prints number of records, and seconds to execute
     *
     * @param treeMap string carMake, array list of sale record objects
     */
    public static void experimentWithInsertionSort(TreeMap<String, ArrayList<SaleRecord>> treeMap){
        System.out.println("Modified Quick Sort: ");
        for (Map.Entry<String, ArrayList<SaleRecord>> entry : treeMap.entrySet()) {
            ArrayList<SaleRecord> tries = entry.getValue();
            System.out.print(entry.getKey() + ": ");
            int count = 0;
            long startTime = System.currentTimeMillis();
            modifiedQuickSort quickSort = new modifiedQuickSort(tries);
            long endTime = System.currentTimeMillis();
            float finalTime = (float) (endTime - startTime) / 1000;
            count += tries.size();
            System.out.printf(count + " records\t" + finalTime + " seconds\n");

        }
    }

    /**
     * Reads line from CSV and returns SaleRecord object
     *
     * @param line line from CSV file
     * @return SaleRecord object
     */
    private static SaleRecord parsingCSV(String line) {
        String[] parts = line.split(",");
        if (parts.length != 9) {
            return null;
        }
        String date = parts[0];
        String carMake = parts[3];


        return new SaleRecord(date, carMake);
    }

    /**
     * populates treeMap from CSV file
     *
     * @param csvFilePath path to csv
     * @param treeMap string carMake, array list of sale record objects
     */
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

    /**
     * Method to populate treeMap
     *
     * @param saleRecord saleRecord object
     * @param treeMap string carMake, array list of sale record objects
     */
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