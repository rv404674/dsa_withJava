package graphs.dfsPractice;

/*
Time - 4*O(m*n)
Space - O(m*n)
 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int r = grid.length, c = grid[0].length;
        int totalIslands = 0;

        // by default false
        boolean[][] visited = new boolean[r][c];


        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    totalIslands += 1;
                    dfs(i, j, r, c, grid, visited);
                }
            }

        return totalIslands;
    }

    public void dfs(int i, int j, int r, int c, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int x = 0; x < 4; x++) {
            int xx = i + dx[x];
            int yy = j + dy[x];

            if (xx >= 0 && xx < r && yy >= 0 && yy < c && grid[xx][yy] == '1' && !visited[xx][yy]) {
                dfs(xx, yy, r, c, grid, visited);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grid));

    }

}
