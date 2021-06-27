package Graph;
import  java.util.*;
public class PrimsAlgo {
    static int minKey(int []cost, boolean []mstSet){
        int minVal=Integer.MAX_VALUE,minIndex=-1;
        for(int v=0;v<cost.length;v++){
            if(mstSet[v]==false && cost[v]<minVal){
                minVal=cost[v];
                minIndex=v;
            }
        }
        return minIndex;
    }
    static void printMST(int []parent,int [][]graph){
        System.out.println("Edge \tWeight");
        for (int i = 1; i < parent.length; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
    static void primsAlgo(int [][]graph){
        int V=graph.length;
        boolean []mstSet=new boolean[V];//all set false
        int []cost=new int[V];
        for(int i=0;i<cost.length;i++)
            cost[i]=Integer.MAX_VALUE;
        cost[0]=0;
        int []parent=new int[V];
        Arrays.fill(parent,-1);
        int minCost=0;
        for(int count=0;count <V-1;count++){
            int u=minKey(cost,mstSet);
            mstSet[u]=true;
            for(int v=0;v<V;v++){
                if(graph[u][v]!=0 && mstSet[v]==false && graph[u][v]<cost[v]){
                    parent[v]=u;
                    cost[v]=graph[u][v];
                }
            }
        }
        for(int val:cost)minCost+=val;
        System.out.println("MST Cost is : "+minCost);
        printMST(parent,graph);
        System.out.print("Parent Array : ");
        for(int val:parent) {
            System.out.print(val + " ");
        }
    }
    public static void main(String[] args) {
    int [][]graph=new int[][]{
            //   Assignment Question 1
            {0,5,3,0,0,0,0},
            {5,0,4,6,2,0,0},
            {3,4,0,5,0,6,0},
            {0,6,5,0,6,6,0},
            {0,2,0,6,0,3,5},
            {0,0,6,6,3,0,4},
            {0,0,0,0,5,4,0}};
    primsAlgo(graph);
    }
}
