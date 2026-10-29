class Solution {

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        // return max area of an island in grid
        // do dfs to check for island
        // for every '1' increment local area

        int max = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(dfsarea(grid, r, c), max);
                }
            }
        }

        return max;

    }

    private int dfsarea(int[][] grid, int r, int c) {
        // base case: OOB or 0!
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        
        grid[r][c] = 0; // already seen!

        int res = 1;

        for (int[] dir : dirs) {
            // increment
            res += dfsarea(grid, r + dir[0], c + dir[1]);
        }

        return res;

    }
}
