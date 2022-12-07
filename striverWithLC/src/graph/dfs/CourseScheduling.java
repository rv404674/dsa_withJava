package graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// NOTE: Thought Process.
// cycle detection in an directed graph
// NOTE: it is diff that that of undirected graph.
// NOTE: it is a directed graph.
// https://www.youtube.com/watch?v=uzVUw90ZFIg&t=305s
// [[1,4],[2,4],[3,1],[3,2]]
// NOTE: do a dry run to understand better.

class CourseScheduling {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        // dfsVisited will be used to track visited nodes in the same path.
        // check striver video for clearity.

        boolean[] dfsVisited = new boolean[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // populate the graph
        for(int i=0; i<= numCourses; i++)
            graph.put(i, new ArrayList<>());

        for(int[] a: prerequisites){
            // we learnt that hashMap.get() gives you a reference of alist. So you dont need to do a put.
            graph.get(a[0]).add(a[1]);
        }

        // need to handle discconnected components as well;
        // NOTE: dfs will return true for a cycle.
        // you have to return whether courses can be scheduled or not.
        for(int i=0; i<numCourses; i++)
            if(!visited[i])
                if(isCyclic(i, visited, dfsVisited, graph) == true)
                    return false;

        return true;
    }

    // will return true for a cycle.
    public boolean isCyclic(int curNode, boolean[] visited, boolean[] dfsVisited, HashMap<Integer, List<Integer>> graph){
        visited[curNode] = true;
        dfsVisited[curNode] = true;

        for(Integer neighbour: graph.get(curNode)){
            if(!visited[neighbour]){
                if ( isCyclic(neighbour, visited, dfsVisited, graph) == true)
                    return true;
            } else {
                if(dfsVisited[neighbour] == true)
                    return true;
            }
        }

        dfsVisited[curNode] = false;

        return false;
    }

    public static void main(String[] args) {
        CourseScheduling courseScheduling = new CourseScheduling();
        int numCourses = 5;
        int[][] prerequisites = {
                {0,1},
                {1,2}, {2,3}, {3,4}
        };

        int num2 = 4;
        int[][] pre2 = {
            {2,0}, {2,1}, {0,3}, {1,3}
        };

        System.out.print(courseScheduling.canFinish(num2, pre2));
    }
}