import java.util.*;

/**
 * @author Jere Perisic
 * @version November 30, 2023,
 * QuickSort method with six different partitions
 */
public class QuickSort {

    /**
     * Constructor
     *
     * @param saleRecords arrayList of SaleRecord objects
     * @param partitionNum number of partition to be executed
     */
    public QuickSort(ArrayList<SaleRecord> saleRecords, int partitionNum){
            sort(saleRecords,0,saleRecords.size()-1, partitionNum);
    }

    /**
     * method that sets partition index, and calls itself recursively until it is sorted
     *
     * @param saleRecords arrayList of SaleRecord objects
     * @param begin first value
     * @param end last value
     * @param partitionNum partition to be executed
     */
    public void sort(ArrayList<SaleRecord> saleRecords,int begin,int end, int partitionNum){
            if(begin<end){
                int partitionIndex = 0;
                if(partitionNum == 1) {
                    partitionIndex = partition1(saleRecords, begin, end);
                } else if(partitionNum == 2){
                    partitionIndex = partition2(saleRecords, begin, end);
                }else if(partitionNum == 3){
                    partitionIndex = partition3(saleRecords, begin, end);
                }else if(partitionNum == 4){
                    partitionIndex = partition4(saleRecords, begin, end);
                }else if(partitionNum == 5){
                    partitionIndex = partition5(saleRecords, begin, end);
                }else if(partitionNum == 6){
                    partitionIndex = partition6(saleRecords, begin, end);
                }
            sort(saleRecords,begin,partitionIndex-1, partitionNum);
            sort(saleRecords,partitionIndex+1,end, partitionNum);
            }
        }

    /**
     * Partition one, takes last value as a pivot
     *
     * @param saleRecords arrayList of SaleRecord objects
     * @param begin first value
     * @param end last value
     * @return index of the partition pivot
     */
    private int partition1(ArrayList<SaleRecord> saleRecords, int begin, int end){
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

    /**
     * partition two takes first value as a pivot
     *
     * @param saleRecords arrayList of SaleRecord objects
     * @param begin first value
     * @param end last value
     * @return index of the partition pivot
     */
    private int partition2(ArrayList<SaleRecord> saleRecords,int begin,int end){
            String pivot = saleRecords.get(begin).getDate();
            int i= begin - 1;
            for(int j = begin; j < end; j++){
                if(saleRecords.get(j).getDate().compareTo(pivot) <= 0){
                i++;

                SaleRecord temp=saleRecords.get(i);
                saleRecords.set(i,saleRecords.get(j));
                saleRecords.set(j,temp);
                }
            }
            SaleRecord temp = saleRecords.get(i+1);
            saleRecords.set(i+1,saleRecords.get(end));
            saleRecords.set(end,temp);

            return i+1;
        }

    /**
     * partition three takes middle value as pivot
     *
     * @param saleRecords arrayList of SaleRecord objects
     * @param begin first value
     * @param end last value
     * @return index of the partition pivot
     */
    private int partition3(ArrayList<SaleRecord> saleRecords, int begin, int end){
        int mid = begin + (end - begin) / 2;
        String pivot = saleRecords.get(mid).getDate();
        int i = begin -1;
        for(int j = begin; j < end; j++){
            if(saleRecords.get(j).getDate().compareTo(pivot) >= 0){
                i++;

                SaleRecord temp = saleRecords.get(i);
                saleRecords.set(i, saleRecords.get(j));
                saleRecords.set(j, temp);
            }
        }
        SaleRecord temp = saleRecords.get(i+1);
        saleRecords.set(i+1, saleRecords.get(mid));
        saleRecords.set(mid,temp);
        return i+1;
    }

    /**
     * finds median value of first, middle, and last value of saleRecord arraylist.
     *
     * @param top first value
     * @param mid middle value
     * @param bot last value
     * @return median value
     */
    private int medianOfThree(int top, int mid, int bot){
        int[] arr = {top, mid, bot};
        Arrays.sort(arr);
        return arr[1];
    }
    /**
     * Partition four, takes median value of first, middle, and last as pivot
     *
     * @param saleRecords arrayList of SaleRecord objects
     * @param begin first value
     * @param end last value
     * @return index of the partition pivot
     */
    private int partition4(ArrayList<SaleRecord> saleRecords, int begin, int end){
        int mid = begin + (end - begin) / 2;
        int median = medianOfThree(begin,mid,end);
        String pivot = saleRecords.get(median).getDate();
        int i = begin - 1;
        for(int j = begin; j < end; j++){
            if(saleRecords.get(j).getDate().compareTo(pivot) >= 0){
                i++;

                SaleRecord temp = saleRecords.get(i);
                saleRecords.set(i, saleRecords.get(j));
                saleRecords.set(j, temp);
            }
        }
        SaleRecord temp = saleRecords.get(i+1);
        saleRecords.set(i+1,saleRecords.get(median));
        saleRecords.set(median, temp);

        return i+1;
    }

    /**
     * partition five, takes a random value as a pivot
     *
     * @param saleRecords arrayList of SaleRecord objects
     * @param begin first value
     * @param end last value
     * @return index of the partition pivot
     */
    private int partition5(ArrayList<SaleRecord> saleRecords, int begin, int end) {
        Random randInt = new Random();
        int num = randInt.nextInt(saleRecords.size());
        String pivot = saleRecords.get(num).getDate();
        int i = begin - 1;
        for(int j = begin; j < end; j++){
            if(saleRecords.get(j).getDate().compareTo(pivot) >= 0){
                i++;

                SaleRecord temp = saleRecords.get(i);
                saleRecords.set(i, saleRecords.get(j));
                saleRecords.set(j, temp);
            }
        }

        SaleRecord temp = saleRecords.get(i+1);
        saleRecords.set(i+1,saleRecords.get(num));
        saleRecords.set(num, temp);
        return i+1;
    }

    /**
     * returns a median value of ten randomly chosen values
     *
     * @param saleRecords ArrayList of SaleRecord objects
     * @return
     */
    private int medianOfTen(ArrayList<SaleRecord> saleRecords){
        Random random = new Random();
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++){
            int num = random.nextInt(saleRecords.size());
            arr[i] = num;
        }
        Arrays.sort(arr);
        int n = arr.length / 2;
        return arr[n];
    }

    /**
     * Partition six, takes median of ten values as pivot
     *
     * @param saleRecords arrayList of SaleRecord objects
     * @param begin first value
     * @param end last value
     * @return index of the partition pivot
     */
    private int partition6(ArrayList<SaleRecord> saleRecords, int begin, int end) {
        int num = medianOfTen(saleRecords);
        String pivot = saleRecords.get(num).getDate();
        int i = begin - 1;
        for(int j = begin; j < end; j++){
            if(saleRecords.get(j).getDate().compareTo(pivot) >= 0){
                i++;

                SaleRecord temp = saleRecords.get(i);
                saleRecords.set(i, saleRecords.get(j));
                saleRecords.set(j, temp);
            }
            SaleRecord temp = saleRecords.get(i+1);
            saleRecords.set(i+1, saleRecords.get(num));
            saleRecords.set(num, temp);
        }
        return i+1;
    }


}
