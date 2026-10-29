class Solution {
    public int orangesRotting(int[][] grid) {
        // number of mins elapsed until zero fresh fruits remaining
        // update in rings/levels from rotten fruit: use bfs!
        // use queue to keep track of our rotten oranges

        int mins = 0;
        int fresh = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();

        // init our queue of rotten oranges!
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[] {r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        while (!q.isEmpty() && fresh > 0) {
            // we need to increment mins for each level -> q's size!
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] orange = q.poll();

                for (int[] dir : dirs) {
                    int r = orange[0] + dir[0], c = orange[1] + dir[1];
                    
                    // skip if loc OOB or rotten or already seen
                    if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) continue;

                    if (grid[r][c] == 1) {
                        q.add(new int[] {r, c}); // add our new rotten fruit
                        grid[r][c] = 2;
                        fresh--; // keep track of fresh
                    }
                }
            }

            mins++;
        }

        return fresh == 0 ? mins : -1;
    }
}
