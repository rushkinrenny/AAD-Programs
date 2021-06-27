package Graph;

import java.util.Arrays;

public class dijkristrasAlgo {
    final static int INF=999;
    static int[]dijkstraAlgo(int [][]graph,int src){
        int V=graph.length;
        int []dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        boolean []finalized=new boolean[V];//default false
        for(int count=0;count<V-1;count++){
            int u=-1;
            for(int i=0;i<V;i++){
                if(!finalized[i] && (u==-1 || dist[i]<dist[u]))
                    u=i;
            }
            finalized[u]=true;

            for(int v=0;v<V;v++){
                if(!finalized[v] && graph[u][v]!=0)
                    dist[v]=Integer.min(dist[v],dist[u]+graph[u][v]);
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int [][]graph=new int[][]{
                {0,   7,  9,INF,INF, 14},
                {7,0,10,15,INF,INF},
                {9,10,0,11,INF,2},
                {INF,15,11,0,6,INF},
                {INF,INF,INF,6,0,9},
                {14,INF,2,INF,9,0}
        };
        int []result=dijkstraAlgo(graph,0);
        System.out.print("Distance from source 0 : ");
        for(int val:result)
            System.out.print(val+" ");
    }
}
