class Solution {

    private int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        // we can use dfs here to keep track of number of islands
        // iterate thru grid
        // once we find 1 (land) --> dfs thru neighbors and turn to 0

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
        // base case: r or c oob!
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // now grid[r][c] = 1! land.
        grid[r][c] = '0';

        // update grid[r][c]'s neighbors
        for (int[] dir : dirs) {
            int row = r + dir[0], col = c + dir[1];

            dfs(grid, row, col);
        }

    }
}
