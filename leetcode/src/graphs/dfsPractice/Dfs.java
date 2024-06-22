package graphs.dfsPractice;

import java.util.Iterator;
import java.util.LinkedList;

/*
NOTE: we need to change the implementation to a HashMap, if we get alphabetical nodes.
 */
class Graph {
    private int V;
    // an array having value as LinkedList<Integer> for each index.
    // int[] array = new int[3];
    private LinkedList<Integer>[] adjacenyList;

    Graph(int v) {
        this.V = v;
        this.adjacenyList = new LinkedList[v];
        for (int i=0; i<v; i++)
            adjacenyList[i] = new LinkedList<>();
    }

    void addEdge(int x, int y){
        this.adjacenyList[x].add(y);
    }

    void printGraph(){
        System.out.println("Printing graph");
        for(int i=0; i<V;i++){
            System.out.println("Edges from: " + i + adjacenyList[i]);
        }
    }

    void dfs(){
        boolean[] visited = new boolean[this.V];
        dfsUtil(0, visited);
    }

    void dfsUtil(Integer node, boolean[] visited){
        System.out.println(node);
        visited[node] = true;

//        Iterator<Integer> neighbours = adjacenyList[node].iterator();
//        while(neighbours.hasNext()){
//            int neighbour = neighbours.next();
//            if(!visited[neighbour]) {
//                dfsUtil(neighbour, visited);
//            }
//        }
        for(int neighbour : adjacenyList[node]){
            if(!visited[neighbour]){
                dfsUtil(node, visited);
            }
        }
    }
}


public class Dfs {
    public static void main(String[] args){
        Graph graph = new Graph(6);

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        graph.addEdge(5, 3);

        graph.printGraph();
        System.out.println("DFS Started");
        graph.dfs();
    }
}
