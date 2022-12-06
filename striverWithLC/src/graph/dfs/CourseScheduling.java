package graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// NOTE: Thought Process.
// if we find a node that has been visited and it is not the parent, then we have a cycle.
// Video - https://www.youtube.com/watch?v=zQ3zgFypzX4
// NOTE: it is a directed graph.
// [[1,4],[2,4],[3,1],[3,2]]
// if you apply cycle detection for undirected graph, you will get error.

class CourseScheduling {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // by default false
        if(prerequisites.length <= 2)
            return true;

        boolean[] visited = new boolean[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // populate the graph
        for(int i=0; i<= numCourses; i++)
            graph.put(i, new ArrayList<>());

        for(int[] a: prerequisites){
            // we learnt that hashMap.get() gives you a reference of alist. So you dont need to do a put.
            List<Integer> neighbour = graph.getOrDefault(a[0], new ArrayList<>());
            neighbour.add(a[1]);
        }

        // need to handle discconnected components as well;
        // NOTE: dfs will return true for a cycle.
        // you have to return whether courses can be scheduled or not.
        for(int i=0; i<numCourses; i++)
            if(!visited[i])
                if(dfs(i, -1, visited, graph) == true)
                    return false;

        return true;
    }

    // will return true for a cycle.
    public boolean dfs(int curNode, int parentNode, boolean[] visited, HashMap<Integer, List<Integer>> graph){
        visited[curNode] = true;

        for(Integer neighbour: graph.get(curNode)){
            if(!visited[neighbour]){
                // if got an cycle, just return.
                if (dfs(neighbour, curNode, visited, graph) == true)
                    return true;
            } else {
                // if it has been visited and is not the parent - cycle encountered
                if(neighbour != parentNode)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CourseScheduling courseScheduling = new CourseScheduling();
        int numCourses = 5;
        int[][] prerequisites = {
                {0,1},
                {1,2}, {2,3}, {3,4}
        };

        int num2 = 2;
        int[][] pre2 = {
            {1,0}
        };

        System.out.print(courseScheduling.canFinish(num2, pre2));
    }
}