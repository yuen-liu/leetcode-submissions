class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> square = new HashMap<>();

        // add numbers to maps
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String squareKey = (i / 3) + "," + (j / 3);
                if (board[i][j] != '.') { 
                    // rows
                    if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j])) {
                        return false;
                    }
                    rows.get(i).add(board[i][j]);

                    // squares
                    if (square.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[i][j])) {
                        return false;
                    }
                    square.get(squareKey).add(board[i][j]);

                    // cols
                    if (cols.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j])) {
                        return false;
                    }
                    cols.get(j).add(board[i][j]);
                }


            }
        }

        return true;

    }
}
