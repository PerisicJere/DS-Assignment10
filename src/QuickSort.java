import java.util.ArrayList;

public class QuickSort {


    public QuickSort(ArrayList<SaleRecord> saleRecords, int partitionNum){
            sort(saleRecords,0,saleRecords.size()-1, partitionNum);
    }
    public void sort(ArrayList<SaleRecord> saleRecords,int begin,int end, int partitionNum){
            if(begin<end){
                int partitionIndex = 0;
                if(partitionNum == 1) {
                    partitionIndex = partition1(saleRecords, begin, end);
                } else if(partitionNum == 2){
                    partitionIndex = partition2(saleRecords, begin, end);
                }else if(partitionNum == 3){
                    partitionIndex = 0;//partition3(saleRecords, begin, end);
                }else if(partitionNum == 4){
                    partitionIndex = 0;//partition4(saleRecords, begin, end);
                }else if(partitionNum == 5){
                    partitionIndex = 0;//partition5(saleRecords, begin, end);
                }else if(partitionNum == 6){
                    partitionIndex = 0;//partition6(saleRecords, begin, end);
                }
            sort(saleRecords,begin,partitionIndex-1, partitionNum);
            sort(saleRecords,partitionIndex+1,end, partitionNum);
            }
        }
    private int partition1(ArrayList<SaleRecord> saleRecords, int begin, int end){
        String pivot = saleRecords.get(end).getDate();
        int i = begin - 1;

        for(int j = begin; j <= end; j++){
            if(saleRecords.get(j).getDate().compareTo(pivot) > 0){
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
    private int partition2(ArrayList<SaleRecord> saleRecords,int begin,int end){
            String pivot = saleRecords.get(end).getDate();
            int i=begin - 1;
            for(int j=begin; j<end; j++){
                if(saleRecords.get(j).getDate().compareTo(pivot) >= 0){
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


}
