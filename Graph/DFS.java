package Graph;
import java.util.*;
public class DFS {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){
        //for undirected graph
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void dfs(ArrayList<ArrayList<Integer>>adj,int vertices, int source,HashMap<Integer,Character>hm){
        boolean []visited =new boolean[vertices];
        Stack<Integer> st=new Stack<>();
        visited[source]=true;
        st.add(source);
        System.out.println("DFS of Graph is : ");
        while (st.isEmpty()==false){
            int u=st.pop();
            System.out.print(hm.get(u)+" ");
            for(int v:adj.get(u)){
                if(visited[v]==false){
                    visited[v]=true;
                    st.push(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices=12;
        HashMap<Integer,Character>hm=new HashMap<>();
        char ch='a';
        for(int i=0;i<vertices;i++){
            hm.put(i,ch++);
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>(vertices);
        for(int i=0;i<vertices;i++)
            adj.add(new ArrayList<>());
        // all edges
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        addEdge(adj,1,4);
        addEdge(adj,3,5);
        addEdge(adj,4,6);
        addEdge(adj,4,7);
        addEdge(adj,6,8);
        addEdge(adj,6,9);
        addEdge(adj,7,10);
        addEdge(adj,8,11);
        addEdge(adj,9,11);
        dfs(adj,vertices,0,hm);

    }
}
