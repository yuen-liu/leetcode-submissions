class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // brute force: dfs w/ backtracking
        // better way: bfs! use a queue to keep track of the treasures
        // then expand outwards from each treasure
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j}); // we add the location of treasure
                }
            }
        }

        if (q.size() == 0) return; // no treasures -> end early

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int[] node = q.poll(); // get treasure location
            int row = node[0];
            int col = node[1];

            for (int[] dir : dirs) { // update q for each neighbor
                // skip update logic if char OOB or seen (!INT)
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE) continue;

                // if unseen char then we need to increment grid pos!
                // also add this new updated neighbor to the q
                q.add(new int[] {r, c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
