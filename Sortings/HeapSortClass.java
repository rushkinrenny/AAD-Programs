package Sortings;

public class HeapSortClass {
    public  static void maxHeapify(int []arr,int n,int i){
        int largest=i;
        int lc=2*i+1;
        int rc=2*i+2;
        if(lc<n && arr[lc]>arr[largest]) largest=lc;
        if(rc<n && arr[rc]>arr[largest]) largest=rc;
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            maxHeapify(arr,n,largest);
        }
    }
    public static void  heapSort(int[] arr){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            maxHeapify(arr,n,i);
        }
        for(int i=n-1;i>0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            int flag=0;
            for(int val:arr) {
                if(flag==0)
                    System.out.println("pass "+(n-i));
                System.out.print(val+" ");
                flag=1;
            }
            System.out.println();
            maxHeapify(arr,i,0);

        }
    }
    public static void main(String[] args) {
          int[] arr = new int[]{71, 10, 31, 41, 16, 46, 51, 21, 13, 8};
            heapSort(arr);
            System.out.println();
    }
}
