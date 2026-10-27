class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // brute force method which is O(N^2) is to iterate through every row & col
        // optimal soln: use binary search
        // what's key here is to first find which row we want to look at
        // and then perform binary search in that row to find the target

        int ROWS = matrix.length; // num rows
        int COLS = matrix[0].length; // num cols

        // binary search to find the correct row
        int top = 0, bot = ROWS - 1, row = 0;
        while (top <= bot) {
            row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }

        // binary search in row
        int l = 0, r = COLS - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target > matrix[row][m]) {
                l = m + 1;
            } else if (target < matrix[row][m]) {
                r = m - 1;
            } else {
                return true;
            }
        }

        return false;

        
    }
}
