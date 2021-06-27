package Sortings;

public class Sorting_n2 {
    public  static void swap(int i, int j,int[]a){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public  static void SelectionSort(int[]arr){
        for(int i=0;i<arr.length;i++){
            int pos=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[pos]>arr[j]){
                    pos=j;
                }
            }
            swap(i,pos,arr);
        }
    }
    public  static void InsertionSort(int[]arr){
        for(int i=1;i< arr.length;i++){
            int key=arr[i];
            int j=i;
            while(j>=1 && arr[j-1]>key){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=key;
        }
    }
    public  static void BubbleSort(int[]arr){

        for(int i=0;i<arr.length-1;i++){
            int flag=0;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]) {
                    swap(j, j + 1,arr);
                    flag = 1;
                }
            }
            if(flag==0)break;
        }
    }
    public static void main(String[] args) {
        int loop=1;
        while(loop<=10) {
                int n=10000*loop;
                int []a=new int[n];
            int []b=new int[n];
            int []c=new int[n];
            for(int i=a.length-1;i>=0;i--){
                a[i]=b[i]=c[i]=a.length-i;
            }
            long startTime = System.currentTimeMillis();
            InsertionSort(a);
            long endTime = System.currentTimeMillis();
            System.out.println("Time for Insertion sort : " + (endTime - startTime)+" ms");

            startTime = System.currentTimeMillis();
            SelectionSort(b);
            endTime = System.currentTimeMillis();
            System.out.println("Time for Selection sort : " + (endTime - startTime)+" ms");

            startTime = System.currentTimeMillis();
            BubbleSort(c);
            endTime = System.currentTimeMillis();
            System.out.println("Time for Bubble sort    : " + (endTime - startTime)+" ms");
            System.out.println();
            loop++;
        }
    }
}
