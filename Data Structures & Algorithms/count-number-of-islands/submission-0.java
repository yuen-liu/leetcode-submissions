class Solution {

    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        // approach: bfs - visit each neighbor and check if it's a 1
        // we always add to a seen hashset
        // and return num islands
        int ROWS = grid.length, COLS = grid[0].length;
        int islands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    // we call bfs once we reach dry land
                    // and increment islands
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }

        return islands;
    }

/**
bfs: private algorithm that implements a seen hashset
**/
    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>(); // use a queue for bfs (FIFO)
        grid[r][c] = '0'; // reset this square so no duplicates
        q.add(new int[]{r, c});

        while (!q.isEmpty()) { // keep going through the queue
            int[] node = q.poll(); // gives us our first neighbor
            int row = node[0], col = node[1];

            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0'; // reset
                }
            }
        }
    }
}
