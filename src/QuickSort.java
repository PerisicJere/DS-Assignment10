import java.util.ArrayList;

public class QuickSort {


    public QuickSort(ArrayList<SaleRecord> saleRecords){
            sort(saleRecords,0,saleRecords.size()-1);
            }
    public void sort(ArrayList<SaleRecord> saleRecords,int begin,int end){
            if(begin<end){
            int partitionIndex = partition1(saleRecords,begin,end);

            sort(saleRecords,begin,partitionIndex-1);
            sort(saleRecords,partitionIndex+1,end);
            }
        }
    private int partition1(ArrayList<SaleRecord> saleRecords,int begin,int end){
            String pivot=saleRecords.get(end).getDate();
            int i=begin-1;
            for(int j=begin;j<end; j++){
            if(saleRecords.get(j).getDate().compareTo(pivot)<=0){
            i++;

            SaleRecord temp=saleRecords.get(i);
            saleRecords.set(i,saleRecords.get(j));
            saleRecords.set(j,temp);
                }
            }
            SaleRecord temp=saleRecords.get(i+1);
            saleRecords.set(i+1,saleRecords.get(end));
            saleRecords.set(end,temp);

            return i+1;
        }

}
