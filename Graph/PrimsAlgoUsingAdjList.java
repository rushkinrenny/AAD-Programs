package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PrimsAlgoUsingAdjList {
    static class Node implements Comparable<Node>{
        private int v;
        private int weight;
        Node(){};
        Node(int v,int weight){
            this.v=v;
            this.weight=weight;
        }
        int getV(){return v;}
        int getWeight(){return weight;}

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }
    static void primsAlgo(ArrayList<ArrayList<Node>>adj,int N){
        int []key=new int[N];
        int []parent=new int[N];
        boolean []mstSet=new boolean[N];
        Arrays.fill(key,Integer.MAX_VALUE);
        Arrays.fill(parent,-1);
        Arrays.fill(mstSet,false);
        PriorityQueue<Node>pq=new PriorityQueue<>();
        key[0]=0;
        pq.add(new Node(0,key[0]));

        for(int i=0;i<N-1;i++){
            int u=pq.poll().getV();
            mstSet[u]=true;
            for(Node e:adj.get(u)){
                if(mstSet[e.getV()]==false && e.getWeight()<key[e.getV()]){
                    parent[e.getV()]=u;
                    key[e.getV()]=e.getWeight();
                    pq.add(new Node(e.getV(),key[e.getV()]));
                }
            }
        }
        System.out.println("Edge\tWeight");
        for(int i=1;i<N;i++){
            System.out.println(parent[i]+" - "+i+"\t  "+key[i]);
        }
        for(int i:parent) System.out.print(i+" ");
    }

    public static void main(String[] args) {
        /*
        Assignment Question 1
        int [][]graph=new int[][]{
            {0,5,3,0,0,0,0},
            {5,0,4,6,2,0,0},
            {3,4,0,5,0,6,0},
            {0,6,5,0,6,6,0},
            {0,2,0,6,0,3,5},
            {0,0,6,6,3,0,4},
            {0,0,0,0,5,4,0}};
         */
        int N=7;
        ArrayList<ArrayList<Node>>adj=new ArrayList<>();
        for(int i=0;i<N;i++)
            adj.add(new ArrayList<Node>());
        adj.get(0).add(new Node(1,5));
        adj.get(1).add(new Node(0,5));

        adj.get(0).add(new Node(2,3));
        adj.get(2).add(new Node(0,3));

        adj.get(1).add(new Node(2,4));
        adj.get(2).add(new Node(1,4));

        adj.get(1).add(new Node(4,2));
        adj.get(4).add(new Node(1,2));

        adj.get(1).add(new Node(3,6));
        adj.get(3).add(new Node(1,6));

        adj.get(2).add(new Node(3,5));
        adj.get(3).add(new Node(2,5));

        adj.get(2).add(new Node(5,6));
        adj.get(5).add(new Node(2,6));

        adj.get(3).add(new Node(4,6));
        adj.get(4).add(new Node(3,6));

        adj.get(3).add(new Node(5,6));
        adj.get(5).add(new Node(3,6));

        adj.get(4).add(new Node(5,3));
        adj.get(5).add(new Node(4,3));

        adj.get(4).add(new Node(6,5));
        adj.get(6).add(new Node(4,5));

        adj.get(5).add(new Node(6,4));
        adj.get(6).add(new Node(5,4));
        primsAlgo(adj,N);
    }
}
