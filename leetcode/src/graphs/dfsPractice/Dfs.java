package graphs.dfsPractice;

import java.util.Iterator;
import java.util.LinkedList;

/*
NOTE: we need to change the implementation to a HashMap, if we get alphabetical nodes.
 */
class Graph{
    private int V;
    private LinkedList<Integer>[] adjancyList;

    public Graph(int v){
        V = v;
        adjancyList = new LinkedList[V];
        for (int i=0; i<v; i++){
            adjancyList[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w){
        adjancyList[v].add(w);
    }

    void printGraph(){
        for(int i=0; i<V; i++)
            System.out.println("Edge from " + i + " " + adjancyList[i]);
    }

    void start_dfs(){
        // false by default in java
        boolean[] visited = new boolean[V];
        dfs_util(0, visited);
    }

    void dfs_util(int node, boolean[] visited){
        System.out.println(node);
        visited[node] = true;

        Iterator<Integer> i = adjancyList[node].iterator();
        while(i.hasNext()){
            int current = i.next();
            if(!visited[current])
                dfs_util(current, visited);
        }
    }
}

public class Dfs {
    public static void main(String[] args){
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);

        graph.start_dfs();


    }
}
