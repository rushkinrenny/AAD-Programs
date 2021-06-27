package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphRepUsingAdjacencyList {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        //for undirected graph
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void displayAdjacencyList(ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<adj.size();i++){
            System.out.print(i+" --> ");
            for(int j=0;j<adj.get(i).size();j++)
                System.out.print(adj.get(i).get(j)+" ");
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>>  createAdjacencyList(int vertices, int edges){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>(vertices);
        Scanner scan=new Scanner(System.in);
        for(int i=0;i<vertices;i++)
            adj.add(new ArrayList<>());

        System.out.println("Enter all edges\nu v");
        for(int i=0;i<edges;i++){
            int u=scan.nextInt();
            int v=scan.nextInt();
            addEdge(adj,u,v);
        }
        return  adj;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter No. of vertices and edges : ");
        int vertices=scan.nextInt();
        int edges=scan.nextInt();
        ArrayList<ArrayList<Integer>>adj=createAdjacencyList(vertices,edges);

        displayAdjacencyList(adj);
    }
}
