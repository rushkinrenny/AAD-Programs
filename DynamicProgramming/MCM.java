package DynamicProgramming;

import java.util.Random;

public class MCM {
    public static int mcm(int arr[]){
        int n=arr.length;
        int [][]dp=new int[n][n];
        int [][]cut=new int[n][n];
        for(int i=0;i<n-1;i++)
            dp[i][i+1]=0;
        for(int gap=2;gap<n;gap++){
            for(int i=0;i+gap<n;i++){
                int j=i+gap;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    int val=dp[i][k]+dp[k][j]+arr[i]*arr[j]*arr[k];
                    if(val<dp[i][j]) {
                        cut[i][j] = k;
                        dp[i][j] = val;
                    }
                }
            }
        }
//        System.out.println("Dp Table : ");
//        for(int i=0;i<dp.length;i++){
//            for(int j=0;j<dp[0].length;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.printf("\n\n");
//        System.out.println("K values table : ");
//        for(int i=0;i<cut.length;i++){
//            for(int j=0;j<cut[0].length;j++){
//                System.out.print(cut[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[0][n-1];
    }

    public  static int[] randomArrayGenerate(int size){
         Random random = new Random();
        int[] randomArray = new int[size];
        int max=size+1;
        int min=1;
        for (int j = 0; j < size; j++) {
            randomArray[j] = random.nextInt(max-min)+min;
        }
        return randomArray;
    }
    public static void main(String[] args) {
//        int []arr=new int[]{2,10,20,3,4,50,60};
//        long start= System.currentTimeMillis();
//        System.out.println("Min cost of matrices multiplication : "+mcm(arr));
//        long end= System.currentTimeMillis();
//        System.out.println("Time taken : "+(end-start) +"ms");
        long start, end;
        for(int i=1;i<=10;i++) {
            int size = 100;
            int[] randomArray = randomArrayGenerate(i*size);
            System.out.println("size : "+i*size);
            start=System.currentTimeMillis();
            mcm(randomArray);
            end=System.currentTimeMillis();
            System.out.println("Time taken : "+(end-start) +"ms");
        }
    }
}
