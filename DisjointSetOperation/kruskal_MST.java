package DisjointSetOperation;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class kruskal_MST {
    static class Edge implements Comparable<Edge>{
        Integer u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.w.compareTo(edge.w);
        }

        @Override
        public String toString() {
            return String.format("u: %3d. v: %3d, w: %3d", u, v, w);
        }
    }

    static ArrayList<Edge> kruskalsAlgo(int n, ArrayList<Edge> edges) {
        ArrayList<Edge> selectedEdges = new ArrayList<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        for(Edge edge: edges) {
            priorityQueue.add(edge);
        }
        DisjointSet disjointSet = new DisjointSet(n);
        while(selectedEdges.size() < n-1) {
            Edge edge = priorityQueue.remove();
            if(!disjointSet.find(edge.u, edge.v)) {
                selectedEdges.add(edge);
                disjointSet.union(edge.u, edge.v);
            }
        }
//        for(int i: disjointSet.parent)
//            System.out.print(i+" ");
//        System.out.println();
        return selectedEdges;
    }

    public  static  class DisjointSet{
        int vertexes;
        int parent[];
        DisjointSet(int vertexes){
            this.vertexes=vertexes;
            parent=new int[vertexes];
            for(int i=0;i<vertexes;i++)
                parent[i]=i;
        }
        int getRepresentative(int vertex) {
            int id;
            if(parent[vertex] == vertex)
                id = vertex;
            else {
                id = getRepresentative(parent[vertex]);
                parent[vertex] = id;
            }
            return id;
        }

        boolean find(int u, int v) {
            return getRepresentative(u) == getRepresentative(v);
        }

        void union(int u, int v) {
            int uId = getRepresentative(u);
            int vId = getRepresentative(v);
            parent[vId] = uId;
        }
    }
    public static void main(String[] args) {
        int n = 8;
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 2, 7));
        edges.add(new Edge(0, 1, 1));
        edges.add(new Edge(1, 4, 6));
        edges.add(new Edge(1, 3, 5));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(4, 6, 9));
        edges.add(new Edge(6, 7, 4));
        edges.add(new Edge(4, 5, 3));
        edges.add(new Edge(5, 7, 8));


        ArrayList<Edge> selectedEdges = kruskalsAlgo(n, edges);

        int weightOfTree = 0;
        System.out.println("Selected Edges:");
        for(Edge edge: selectedEdges) {
            weightOfTree += edge.w;
            System.out.println(edge);
        }
        System.out.println("Weight of Tree: " + weightOfTree);
    }

}
