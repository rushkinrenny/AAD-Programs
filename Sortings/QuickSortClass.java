package Sortings;

public class QuickSortClass {
    public  static void swap(int i, int j,int[]a){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low<high) {
            int pivot = arr[high];
            int pivotIndex = partition(arr, low, high);
            System.out.println("After Partition: Array become");
            for(int val:arr)System.out.print(val+" ");
            System.out.println();
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

    public static void main(String[] args) {
        int arr[]=new int[]{78,21,14,97,87,62,74,85,76,45,84,22};
        quickSort(arr,0,arr.length-1);
        System.out.println("Final Sorted Array");
        for(int val:arr)System.out.print(val+" ");
        System.out.println();
    }
}
