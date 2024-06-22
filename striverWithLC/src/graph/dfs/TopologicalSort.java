package graph.dfs;


// YT - https://practice.geeksforgeeks.org/problems/topological-sort/1
// CRUX - Topological sort, is an ordering that happens only in an DAG
// such that, if there is a directed edge from u -> v
// then u always occur before v.


import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<V; i++)
            if(!visited[i])
                dfs(i, visited, stack, adj);

        int[] ans = new int[V];
        int i = 0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }

        return ans;
    }

    static void dfs(int node, boolean[] visited, Stack stack, ArrayList<ArrayList<Integer>> ad){
        visited[node] = true;

        for(int neighbour: ad.get(node)){
            if(!visited[neighbour])
                dfs(neighbour, visited, stack, ad);
        }

        stack.add(node);
    }
}
