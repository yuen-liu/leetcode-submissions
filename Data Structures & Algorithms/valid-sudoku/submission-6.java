class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> square = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // 1. Check Row i
                char rVal = board[i][j];
                if (rVal != '.') {
                    if (row.contains(rVal)) return false;
                    row.add(rVal);
                }

                // 2. Check Col i
                char cVal = board[j][i];
                if (cVal != '.') {
                    if (col.contains(cVal)) return false;
                    col.add(cVal);
                }

                // 3. Check 3x3 Box i
                int boxRow = 3 * (i / 3) + (j / 3);
                int boxCol = 3 * (i % 3) + (j % 3);
                char bVal = board[boxRow][boxCol];
                if (bVal != '.') {
                    if (square.contains(bVal)) return false;
                    square.add(bVal);
                }
            }
        }

        return true;
    }
}