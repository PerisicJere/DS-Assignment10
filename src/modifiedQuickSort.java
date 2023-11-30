import java.util.ArrayList;

/**
 * @author Jere Perisic
 * @version November 30, 2023,
 * Modified QuickSort with insertion sort.
 * Insertion sort performs better on smaller data sets
 */
public class modifiedQuickSort {
    /**
     * constructor
     *
     * @param saleRecords arrayList of SaleRecord objects
     */
    public modifiedQuickSort(ArrayList<SaleRecord> saleRecords){
        quickSort(saleRecords, 0, saleRecords.size()-1);
    }

    /**
     * Insertion sort that sorts arrayList when partition size is 7 or smaller
     *
     * @param saleRecords arrayList of SaleRecord objects
     * @param begin first value
     * @param end last value
     */
    private static void insertionSort(ArrayList<SaleRecord> saleRecords, int begin, int end){
        for(int i = begin + 1; i <= end; i++) {
            SaleRecord key = saleRecords.get(i);
            int j = i - 1;

            while (j >= begin && saleRecords.get(j).getDate().compareTo(key.getDate()) > 0) {
                saleRecords.set(j+1, saleRecords.get(j));
                j--;
            }
            saleRecords.set(j+1, key);
        }
    }

    /**
     * quick sort algorithm that calls recursive call until size is 7 or smaller. Then it calls insertion sort
     *
     * @param saleRecords arrayList of SaleRecord objects
     * @param begin first value
     * @param end last value
     */
    public void quickSort(ArrayList<SaleRecord> saleRecords,int begin,int end){
        while (begin < end) {
            if (end - begin <= 7) {
                insertionSort(saleRecords, begin, end);
                break;
            } else {
                int pivot = partition(saleRecords, begin, end);

                if (pivot - begin < end - pivot) {
                    quickSort(saleRecords, begin, pivot - 1);
                    begin = pivot + 1;
                } else {
                    quickSort(saleRecords, pivot + 1, end);
                    end = pivot - 1;
                }
            }
        }
    }

    /**
     *partition that takes the last values as pivot
     *
     * @param saleRecords arrayList of SaleRecord objects
     * @param begin first value
     * @param end last value
     * @return index of partition pivot
     */
    private int partition(ArrayList<SaleRecord> saleRecords, int begin, int end) {
        String pivot = saleRecords.get(end).getDate();
        int i = begin - 1;

        for (int j = begin; j < end; j++) {
            if (saleRecords.get(j).getDate().compareTo(pivot) <= 0) {
                i++;

                SaleRecord temp = saleRecords.get(i);
                saleRecords.set(i, saleRecords.get(j));
                saleRecords.set(j, temp);
            }
        }
        SaleRecord temp = saleRecords.get(i+1);
        saleRecords.set(i+1, saleRecords.get(end));
        saleRecords.set(end, temp);

        return i;
    }


}
