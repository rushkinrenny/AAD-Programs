package DynamicProgramming;

import java.util.Scanner;

public class OptimalBinarySearchTree {
    public  static void obst(int []p,int []q,int[][]cost, int [][]w, int [][]root){
        int n=cost.length;
        for(int i=0;i<n;i++)
        {
            w[i][i]=q[i];
            cost[i][i]=0;
            root[i][i]=0;
        }
        for(int i=0;i<w.length;i++)
            for(int j=0;j<w[0].length;j++)
                if(i<j)
                    w[i][j]=w[i][j-1]+p[j]+q[j];

        for(int gap=1;gap<n;gap++){
            for(int i=0;i+gap<n;i++){
                int j=i+gap;
                cost[i][j]=Integer.MAX_VALUE;
                for(int k=i+1;k<=j;k++){
                    int val=cost[i][k-1]+cost[k][j]+w[i][j];
                    if(val<cost[i][j]) {
                        root[i][j] = k;
                        cost[i][j] = val;
                    }
                }
            }
        }
    }
    static void displayArray(int [][]arr){
        for(int []row:arr){
            for(int val:row){
                System.out.print(val+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("No. of Keys : ");
        int n=scan.nextInt();// no. of keys
        System.out.print("Enter keys : ");
        int []keys=new int[n+1];
        for(int i=1;i<=n;i++)
            keys[i]=scan.nextInt();
        System.out.print("Enter successful probability   : ");
        int []p=new int[n+1];
        for(int i=1;i<=n;i++)
            p[i]=scan.nextInt();
        System.out.print("Enter unsuccessful probability : ");
        int []q=new int[n+1];
        for(int i=0;i<=n;i++)
           q[i]=scan.nextInt();

        int[][]cost =new int [n+1][n+1];
        int[][]w =new int [n+1][n+1];
        int[][]root =new int [n+1][n+1];
        obst(p,q,cost,w,root);
        System.out.println("Cost is : "+cost[0][n]+"\nRoot is : "+root[0][n]);
        System.out.println("\nCost Table:");
        displayArray(cost);
        System.out.println("\nw Table:");
        displayArray(w);
        System.out.println("\nRoot Table:");
        displayArray(root);

    }
}
