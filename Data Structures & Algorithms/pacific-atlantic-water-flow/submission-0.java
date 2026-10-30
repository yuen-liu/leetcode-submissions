class Solution {

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // find all cells where water can flow from that cell to both
        // pacific & atlantic
        // for every cell on the border: check if its neighbor is lower
        // if neighbor is lower than add
        // otherwise stop there and move on to next
        // use dfs

        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean [][] atl = new boolean[heights.length][heights[0].length];

        for (int c = 0; c < heights[0].length; c++) {
            dfs(0, c, pac, heights);
            dfs(heights.length - 1, c, atl, heights);
        }

        for (int r = 0; r < heights.length; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, heights[0].length - 1, atl, heights);
        }

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true; // valid

        for (int[] d : dirs) {
            int row = r + d[0], col = c + d[1];
            if (row >= 0 && row < heights.length && col >= 0 && col < heights[0].length && !ocean[row][col] && heights[row][col] >= heights[r][c]) {
                dfs(row, col, ocean, heights);
            }
        }

    }
}
