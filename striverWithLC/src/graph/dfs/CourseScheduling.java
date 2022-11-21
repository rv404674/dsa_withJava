package graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// NOTE: Thought Process
// cycle detection in directed graph
// use colouring
// NOTE: CRUX - if neighbour is not parent node and is visited, cycle detected.
// dry run of some test cases
public class CourseScheduling {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=2 || prerequisites.length <=1)
            return true;

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[numCourses];

        for(int[] x: prerequisites){
            if(!graph.containsKey(x[0]))
                graph.put(x[0], new ArrayList<>());
            graph.get(x[0]).add(x[1]);
        }

        for(int i=0; i<numCourses; i++)
            if(!visited[i])
                if(!dfsUtil(i, -1, graph, visited))
                    return false;

        return true;

    }

    public static boolean dfsUtil(int currentNode, int parentNode, HashMap<Integer, List<Integer>> graph, boolean[] visited){
        visited[currentNode] = true;
        for(int neighbour: graph.get(currentNode)){
            if(neighbour!=parentNode && visited[neighbour])
                return false;
            if(!dfsUtil(neighbour, currentNode, graph, visited))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] a = {{0,1}, {1,2}, {2,0}, {3,2}};
        System.out.println(canFinish(numCourses, a));
    }

}
