package Sortings;

import java.util.Arrays;
import java.util.Random;

public class Sorting_nlogn {

    public  static void swap(int i, int j,int[]a){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low<high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<=high-1;j++){
            if(arr[j]<pivot){
                i++;
                swap(i,j,arr);
            }
        }
        swap(i+1,high,arr);
        return i+1;
    }

    public static void mergeSort(int[] arr, int low, int high) {
       if(low<high) {
           int mid = (low + high) / 2;
           mergeSort(arr, low, mid);
           mergeSort(arr, mid + 1, high);
           mergingArray(arr,low,mid,high);
       }

    }
    public static void mergingArray(int[] arr, int low, int mid, int high) {
        int i=low,k=0,j=mid+1;
        int []auxArray=new int[high-low+1];
        while (i<=mid && j<=high){
            if(arr[i]<arr[j]) {
                auxArray[k]=arr[i];
                k++;
                i++;
            }
            else{
                auxArray[k]=arr[j];
                k++;
                j++;
            }
        }
        while (i<=mid){
            auxArray[k]=arr[i];
            k++;
            i++;
        }
        while (j<=high){
            auxArray[k]=arr[j];
            k++;
            j++;
        }
        for(i=low;i<=high;i++){
            arr[i]=auxArray[i-low];
        }

    }

    public static void maxHeapify(int[] arr, int n, int i) {
        int largest = i;
        int lc = 2 * i + 1;
        int rc = 2 * i + 2;
        if (lc < n && arr[lc] > arr[largest]) largest = lc;
        if (rc < n && arr[rc] > arr[largest]) largest = rc;
        if (largest != i) {
            swap(i, largest, arr);
            maxHeapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(i, 0, arr);
            maxHeapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {

        long start, end;
        Random random = new Random();
        for(int i=1;i<=10;i++) {
            int size = 1000000;
            int[]  arr,randomArray = new int[i*size];

            for(int j=0;j<i*size;j++) {
                randomArray[j] = random.nextInt();
            }
            System.out.println("RUN: "+i);
            arr = Arrays.copyOf(randomArray, i*size);
            start = System.currentTimeMillis();
            quickSort(arr, 0, i*size-1);
            end = System.currentTimeMillis();
            System.out.println("Quick sort time taken: " + (end - start) + "ms");

            arr = Arrays.copyOf(randomArray, i*size);
            start = System.currentTimeMillis();
            heapSort(arr);
            end = System.currentTimeMillis();
            System.out.println("Heap sort time taken: " + (end - start) + "ms");

            arr = Arrays.copyOf(randomArray, i*size);
            start = System.currentTimeMillis();
            mergeSort(arr, 0, i*size-1);
            end = System.currentTimeMillis();
            System.out.println("Merge sort time taken: " + (end - start) + "ms");
            System.out.println();

        }
    }
}