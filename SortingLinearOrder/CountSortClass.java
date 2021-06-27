package SortingLinearOrder;

import java.util.Arrays;
import java.util.Collections;

public class CountSortClass {
    public static void countSort(Integer []arr){
        int min= Collections.min(Arrays.asList(arr));
        int max= Collections.max(Arrays.asList(arr));
        int []freqArr=new int[max-min+1];

        for(int i=0;i<arr.length;i++){
            freqArr[arr[i]-min]++;
        }
        System.out.println("Frequency Array:");
        for(int i=0;i<freqArr.length;i++){
            System.out.println("freq of val "+(min+i)+" is "+freqArr[i]+" ");
        }
        // now make prefix sum array;
        for(int i=1;i<freqArr.length;i++){
            freqArr[i]+=freqArr[i-1];
        }
        System.out.println("prefix sum Array:");
        for(int i=0;i<freqArr.length;i++){
            System.out.print(freqArr[i]+" ");
        }
        System.out.println();
        int[] result=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int val=arr[i];
            int pos=freqArr[val-min];
            int idx=pos-1;
            result[idx]=val;
            freqArr[val-min]--;
        }
        for(int i=0;i<arr.length;i++)
            arr[i]=result[i];
    }

    public static void main(String[] args) {
        Integer []arr=new Integer[]{7, 6, 3, 4, 16, 5, 7, 13, 8, 12, 6, 6};
        countSort(arr);
        System.out.println("Final sorted array");
        for(Integer val:arr)System.out.print(val+" ");
    }
}
