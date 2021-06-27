package Graph;
import  java.util.*;
public class BellmanFord {
    static class Node{
        private int u;
        private int v;
        private int wt;
        Node(int u,int v,int wt){
            this.u=u;
            this.v=v;
            this.wt=wt;
        }
        Node(){}
        int getU(){return u;}
        int getV(){return v;}
        int getWt(){return wt;}
    }
    static void bellmanFordAlgo(ArrayList<Node>Edges,int V,int src){
    int []dist=new int[V];
    for(int i=0;i<V;i++)dist[i]=Integer.MAX_VALUE;
    dist[src]=0;
    for(int i=0;i<V-1;i++){
        for(Node node:Edges){
            if(dist[node.getU()]+node.getWt()<dist[node.getV()])
                dist[node.getV()]=dist[node.getU()]+node.getWt();
        }
    }
    // detect negative cycle
        boolean flag=false;
        for(Node node:Edges){
            if(dist[node.getU()]+node.getWt()<dist[node.getV()]) {
                System.out.println("Negative Cycle");
                flag=true;
                break;
            }
        }
        if(flag==false)
        {
            System.out.println("Vertex Weight");
            for(int i = 0;i<V;i++) {
                System.out.println(i + "\t\t" + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Node>adj=new ArrayList<>();
        //assignment ques 1
        int V=5;
        adj.add(new Node(0,1,-1));
        adj.add(new Node(0,2,4));
        adj.add(new Node(1,2,3));
        adj.add(new Node(1,3,2));
        adj.add(new Node(1,4,2));
        adj.add(new Node(3,1,1));
        adj.add(new Node(4,3,-3));
        bellmanFordAlgo(adj,V,0);

    }
}
