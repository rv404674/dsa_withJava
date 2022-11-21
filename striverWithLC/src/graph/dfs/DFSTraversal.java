package graph.dfs;

import java.util.*;

public class DFSTraversal {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList< ArrayList<Integer> > ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(ArrayList<Integer> edge: edges) {
            List<Integer> temp = graph.getOrDefault(edge.get(0), new ArrayList<>());
            temp.add(edge.get(1));
            graph.put(edge.get(0), temp);

            List<Integer> temp2 = graph.getOrDefault(edge.get(1), new ArrayList<>());
            temp2.add(edge.get(0));
            graph.put(edge.get(1), temp2);
        }

        boolean[] visited = new boolean[v];
        for(int i=0; i<v; i++) {
            // if there is not edge for this node
            if(!graph.containsKey(i))
                graph.put(i, new ArrayList<>());

            if (!visited[i]) {
                ArrayList<Integer> path = new ArrayList<>();
                dfsUtil(i, graph, visited, path);
                Collections.sort(path);
                ans.add(path);
            }
        }

        return ans;
    }

    public static void dfsUtil(int node, HashMap<Integer, List<Integer>> graph, boolean[] visited, ArrayList<Integer> path){
        path.add(node);
        visited[node] = true;

        for(int neighbour: graph.get(node)){
            if(!visited[neighbour])
                dfsUtil(neighbour, graph, visited, path);
        }
    }
}
