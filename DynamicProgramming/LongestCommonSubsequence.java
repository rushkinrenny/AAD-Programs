package DynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static int lcs(String a, String b){
        int [][]dp=new int[a.length()+1][b.length()+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(a.charAt(i-1)==b.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        for(int i=0;i<dp.length;i++) {
            for (int j = 0; j < dp[0].length; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        long start,end;
        char option='y';
           while(option=='y' || option =='Y'){
               String a=scn.nextLine();
               String b=scn.nextLine();
               start =System.currentTimeMillis();
               System.out.println("Longest common subsequence is : "+lcs(a,b));
               end=System.currentTimeMillis();
               System.out.println("Time Taken : "+(end-start)+"ms");
               System.out.print("Enter more (y/n): ");
               option=scn.nextLine().charAt(0);
           }
    }
}
