package DivideAndConquer;

import java.util.Scanner;

public class StrassenMatrixMultiplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter order n :");
        int N = scan.nextInt();
        System.out.println("Enter " +N+"X"+N+" order matrix 1");
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                A[i][j] = scan.nextInt();

        System.out.println("\nEnter " +N+"X"+N+" order matrix 2");
        int[][] B = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                B[i][j] = scan.nextInt();
        //Calculate time
        long start1,end1;
        System.out.println("\nSimple Multiplication");
        start1=System.currentTimeMillis();
        int[][] C = simpleMultiply(A, B);
        displayMatrix(C);
        end1=System.currentTimeMillis();
        System.out.println("Time Taken : "+(end1-start1));

        System.out.println("\nStrassen Multiplication");
        long start2,end2;
       start2=System.currentTimeMillis();
        int [][]D=strassenMultiply(A,B);
        displayMatrix(D);
        end2=System.currentTimeMillis();
        System.out.println("Time Taken : "+(end2-start2));

    }
    static int [][] simpleMultiply(int a[][],int b[][]){
        int n=a.length;
        int [][]c=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
    static int [][] strassenMultiply(int [][]A,int [][]B){
        int n=A.length;
        int [][]Result=new int [n][n];
        if(n==1){
            Result[0][0]=A[0][0]*B[0][0];
            return Result;
        }
        else{
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];

            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];

            split(A, A11, 0 , 0);
            split(A, A12, 0 , n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);

            split(B, B11, 0 , 0);
            split(B, B12, 0 , n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);

            int [][] P = strassenMultiply(add(A11, A22), add(B11, B22));
            int [][] Q = strassenMultiply(add(A21, A22), B11);
            int [][] R = strassenMultiply(A11, sub(B12, B22));
            int [][] S = strassenMultiply(A22, sub(B21, B11));
            int [][] T = strassenMultiply(add(A11, A12), B22);
            int [][] U = strassenMultiply(sub(A21, A11), add(B11, B12));
            int [][] V = strassenMultiply(sub(A12, A22), add(B21, B22));

            int [][] C11 = add(sub(add(P, S), T), V);
            int [][] C12 = add(R, T);
            int [][] C21 = add(Q, S);
            int [][] C22 = add(sub(add(P, R), Q), U);


            join(C11, Result, 0 , 0);
            join(C12, Result, 0 , n/2);
            join(C21, Result, n/2, 0);
            join(C22, Result, n/2, n/2);

        }

        return Result;
    }
    public static int [][] sub(int[][] A, int[][] B){
        int n=A.length;
        int [][]C=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                C[i][j]=A[i][j]-B[i][j];
        return C;
    }
    public static int [][] add(int[][] A, int[][] B){
        int n=A.length;
        int [][]C=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                C[i][j]=A[i][j]+B[i][j];
        return C;
    }
    public static void split(int[][] P, int[][] C, int iB, int jB)
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
    public static void join(int[][] C, int[][] P, int iB, int jB)
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }

    public static void displayMatrix(int [][]C){
        int n=C.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }
    }
}
