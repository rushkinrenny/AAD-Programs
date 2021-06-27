package Searching;
import java.util.Scanner;

public class Search {
    public static boolean LinearSearch(int [] arr,int val){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val)
                return true;
        }
        return false;
    }

    public static boolean BinarySearch(int[] arr, int val, int low, int high){
        int mid=(low+high)/2;
        if(low<=high) {
            if (arr[mid] == val) return true;
            else if (arr[mid] < val) {
                return BinarySearch(arr, val, mid + 1, high);
            } else {
                return BinarySearch(arr, val, low, mid - 1);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.print("Size of array : ");
        int n=scn.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=i+1;
        //System.out.println(arr);
        int [] value=new int[]{500,1000,1500,2000,2500,3000,3500,4000,4500,5000};

        for(int i=0;i< value.length;i++){
            System.out.println("Search value : "+value[i]);
            long startTime=System.nanoTime();
            LinearSearch(arr,value[i]);
            long endTime=System.nanoTime();
            System.out.println("Time for Linear Search : "+ (endTime-startTime) +" ns");
            // for Binary Search
            startTime=System.nanoTime();
            BinarySearch(arr,value[i],0,arr.length-1);
            endTime=System.nanoTime();
            System.out.println("Time for Binary Search : "+ (endTime-startTime) +" ns");
            System.out.println();
        }


    }
}
