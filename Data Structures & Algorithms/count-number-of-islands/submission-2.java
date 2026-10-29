class Solution {

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // four directions (NESW)

    public int numIslands(char[][] grid) {
        // we can use DFS to propagate thru the neighbors of a '1'
        // helper method dfs: if OOB/0 we return
        // if 1 -> convert to '0' (alr seen) + continue thru NESW

        int islands = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;

    }

    private void dfs(char[][] grid, int r, int c) {
        // base case: do nothing if character is OOB or a 0
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        for (int[] dir : dirs) {
            dfs(grid, r + dir[0], c + dir[1]);
        }

    }
}
