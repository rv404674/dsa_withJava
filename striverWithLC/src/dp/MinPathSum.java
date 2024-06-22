package dp;

import java.util.Arrays;


// NOTE: AC in 25mins.
public class MinPathSum {
    // Constraints - can only go down and right
    // draw the tree, you will see that there will be a common state
    // use dp with recursion
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        for(int[] a: dp)
        Arrays.fill(a, -1);

        return recurse(0,0, rows, cols, grid, dp);
    }

    public int recurse(int x, int y, int rows, int cols, int[][] grid, int[][] dp){
        // validation
        // NOTE: tricky case, if you return 0, then you will be in problem think.
        if(x<0 || x>=rows || y<0 || y>=cols)
            return Integer.MAX_VALUE;
        // base case
        if(x == rows-1 && y == cols-1)
            return grid[x][y];

        if(dp[x][y] != -1)
            return dp[x][y];

        // you can only go down and right
        int right = recurse(x, y+1, rows, cols, grid, dp);
        int down = recurse(x+1, y, rows, cols, grid, dp);

        dp[x][y] = Math.min(right, down) + grid[x][y];
        return dp[x][y];
    }
}
