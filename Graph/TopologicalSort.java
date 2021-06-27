package Graph;
import java.util.*;
public class TopologicalSort {
    static void addEdge(ArrayList<ArrayList<Integer>>adj,int u,int v){
        adj.get(u).add(v);
    }
    static  void DFS(ArrayList<ArrayList<Integer>>adj,boolean []visited,int u,Stack<Integer> st){
        visited[u]=true;
        for(int edge:adj.get(u)){
            if(visited[edge]==false){
                DFS(adj,visited,edge,st);
            }
        }
        st.push(u);
    }

    static void topologicalSort(ArrayList<ArrayList<Integer>>adj,int Vertices){
        boolean []visited=new boolean[Vertices];
        Stack<Integer>st=new Stack<>();
        for(int v=0;v<Vertices;v++){
            if(visited[v]==false)
                DFS(adj,visited,v,st);
        }

        //print
        System.out.print("Topological Sort : ");
        while(st.size()>0){
            System.out.print(st.pop()+" ");
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int vertices=6;
        //assignment ques=2
        for(int i=0;i<vertices;i++)
            adj.add(new ArrayList<>());
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,1,4);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,3,5);
        addEdge(adj,4,5);
        topologicalSort(adj,vertices);

    }
}
