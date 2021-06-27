package SortingLinearOrder;

public class RadixSortClass {
    public static void radixSort(int[] arr){
    int max=arr[0];
    for(int i=1;i<arr.length;i++){
        if(arr[i]>max)
            max=arr[i];
    }
    int exp=1;
    int pass=1;
    while(exp<=max)//loop till digit of max value
    {
        countSortForRadix(arr,exp);
        exp=exp*10;

        //printing
        System.out.println("After "+pass +" pass");
        for(int val:arr)System.out.print(val+" ");
        System.out.println();
        pass++;
    }
    }
    public static void countSortForRadix(int []arr, int exp){
        int[]freqArray=new int[10];// 0 to 9 digit
        for(int i=0;i<arr.length;i++){
            freqArray[arr[i]/exp%10]++;
        }
        // prefix sum freqArray;
        for(int i=1;i<freqArray.length;i++){
            freqArray[i]+=freqArray[i-1];
        }
        for(int val:freqArray)System.out.print(val+" ");
        System.out.println();
        int []result=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int pos=freqArray[arr[i]/exp%10];
            int idx=pos-1;
            result[idx]=arr[i];
            freqArray[arr[i]/exp%10]--;
        }
        for(int i=0;i<arr.length;i++)
            arr[i]=result[i];
    }

    public static void main(String[] args) {
        int []arr=new int[]{171, 210, 131, 341, 316, 246, 351, 121, 113, 218, 324};
        radixSort(arr);
        System.out.println("Final Sorted Array");
        for(int val:arr)System.out.print(val+" ");
        System.out.println();
    }
}
