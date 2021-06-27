package Graph;

public class FloydWarshall {
    final static int INF=999;
    static void floydWarshall(int [][]graph,int V){
        for(int k=0;k<V;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
            System.out.println("\nD("+(k+1)+")");
            printGraph(graph,V);

        }

    }
    static void printGraph(int [][]graph,int V){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(graph[i][j]==INF)
                    System.out.print("INF\t");
                else System.out.print(graph[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        //assignment ques 1
        int [][]graph={
                {0,   7,  9,INF,INF, 14},
                {7,0,10,15,INF,INF},
                {9,10,0,11,INF,2},
                {INF,15,11,0,6,INF},
                {INF,INF,INF,6,0,9},
                {14,INF,2,INF,9,0}
        };

        floydWarshall(graph,6);
    }
}
