package graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Question Link - https://www.codingninjas.com/studio/problems/dfs-traversal_630462?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
 * NOTE: There might be disconnected components in the graph.
 */
public class DFSTraversal {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[v];

        for (List<Integer> edge : edges){
            // NOTE: In Java objects are always passed by reference.
            // so here even though you are doing a get, it will be reflected in the original graph.
            graph.getOrDefault(edge.get(0), new ArrayList<>()).add(edge.get(1));
            graph.getOrDefault(edge.get(1), new ArrayList<>()).add(edge.get(0));
        }

        for (int i=0; i<v; i++){
            // NOTE: There might be some nodes that disconnected and dont have any any edge to them.
            if(!graph.containsKey(i)){
                graph.put(i, new ArrayList<>());
            }

            if(!visited[i]){
                // start dfs
                ArrayList<Integer> path = new ArrayList<>();
                dFSUtil(i, visited, path, graph);
                ans.add(path);
            }

        }

        return ans;
    }

    public static void dFSUtil(int node, boolean[] visited, ArrayList<Integer> path, HashMap<Integer, List<Integer>> graph) {
        visited[node] = true;
        path.add(node);

        for(int neighbour:graph.get(node)){
            if (!visited[neighbour])
                dFSUtil(neighbour, visited, path, graph);
        }
    }

}
