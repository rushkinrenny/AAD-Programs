package SortingLinearOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSortClass {
    public static void bucketSort(int[] arr,int numberOfBuckets){
        List<List<Integer>> buckets=createBucket(arr,numberOfBuckets);
        int i=0;
        for(List<Integer> bucket:buckets){
            Collections.sort(bucket);
            for(int val:bucket)
                arr[i++]=val;
        }
        System.out.println("Buckets After sort: ");
        i=0;
        for(List<Integer> bucket:buckets){
            System.out.println("bucket Index : "+ i++);
            for(int val:bucket)System.out.print(val+" ");
            System.out.println();

        }
    }
    public static List<List<Integer>> createBucket(int []arr, int numberOfBuckets){
        int maxVal=Integer.MIN_VALUE;
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            if(maxVal<arr[i])maxVal=arr[i];
        }
        maxVal++;
        List<List<Integer>> buckets=new ArrayList<>();
        for(int i=0;i<numberOfBuckets;i++)
            buckets.add(new ArrayList<>());
        for(int val:arr) {
            int bucketIndex=(numberOfBuckets*val)/maxVal;
            buckets.get(bucketIndex).add(val);
        }
        int i=0;
        for(List<Integer> bucket:buckets){
            System.out.println("bucket Index : "+ i++);
            for(int val:bucket)System.out.print(val+" ");
            System.out.println();

        }
        return buckets;
    }
    public static void main(String[] args) {
        int []arr=new int[]{71, 10, 31, 41, 16, 46, 51, 21, 13, 8};
        bucketSort(arr,5);
        for(int val:arr)System.out.print(val+" ");
    }
}
