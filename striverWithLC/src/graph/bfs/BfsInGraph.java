package graph.bfs;

import java.util.* ;
import java.io.*;


public class BfsInGraph {
    public static ArrayList<Integer> BFS(int vertex, int edges[][]){
        // WRITE YOUR CODE HERE
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];

            List<Integer> temp1 = graph.getOrDefault(x, new ArrayList<>());
            temp1.add(y);
            graph.put(x, temp1);

            List<Integer> temp2 = graph.getOrDefault(y, new ArrayList<>());
            temp2.add(x);
            graph.put(y, temp2);
        }


        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertex];
        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);

            for(int neighbour: graph.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }

        // for nodes that are dead nodes
        for(int i=0; i<vertex; i++)
            if(!graph.containsKey(i))
                ans.add(i);

        return ans;
    }

    public static void main(String[] args) {
        int vertex = 2;
        int[][] array = {
                {0,1}
        };

        System.out.println(BFS(vertex, array));
    }

}


