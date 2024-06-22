package graph.bfs;

// https://www.youtube.com/watch?v=yf3oUhkvqA0
// NOTE: Thought Process
//  0 1 2
//  0 1 1
//  2 1 1
// you need to move level wise. From bottom 2 and the up 2, you need to move one level.
// hence use bfs here. DFS wont be used here.
// FIXME: Use your brain and think what to use.
// also when the bfs finishes, if there is still a one that hasn't been visited, return -1.

// TC - O(4*(m*n))
// SC - O(n*m) + O(n*m)

import java.util.LinkedList;
import java.util.Queue;

class QElement {
    int x;
    int y;
    int time;

    public QElement(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<QElement> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        int ansTime = 0;
        int totalOnes = 0;
        int currentOnes = 0;


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.add(new QElement(i, j, 0));
                    visited[i][j] = 2;
                } else if(grid[i][j] == 1){
                    totalOnes +=1;
                }
            }
        }

        while(!queue.isEmpty()){
            QElement qElement = queue.poll();
            ansTime = Math.max(ansTime, qElement.time);

            for(int k=0; k<4; k++){
                int xx = qElement.x + dx[k];
                int yy = qElement.y + dy[k];

                if(isValid(xx, yy, n, m) && grid[xx][yy] == 1 && visited[xx][yy] != 2){
                    visited[xx][yy] = 2;
                    currentOnes +=1;
                    queue.add(new QElement(xx, yy, qElement.time +1));
                }
            }
        }

        if(currentOnes != totalOnes)
            return -1;
        return ansTime;
    }

    public static boolean isValid(int x, int y, int n, int m){
        if(x>=0 && x<n && y>=0 && y<m)
            return true;
        return false;
    }

    public static void main(String[] args) {
        RottingOranges rottingOranges = new RottingOranges();
        int[][] tc1 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(rottingOranges.orangesRotting(tc1));

        int[][] tc2 = {{2,2,1}, {2,1,0}, {0,0,1}};
        System.out.println(rottingOranges.orangesRotting(tc2));
    }

}


