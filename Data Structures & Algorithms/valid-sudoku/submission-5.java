class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> sqrs = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j])) {
                        return false;
                    } else {
                        rows.add(board[i][j]);
                    }

                    int squareindex = (i / 3) * 3 + (j / 3);
                    sqrs.putIfAbsent(squareindex, new HashSet<>());
                    if (sqrs.get(squareindex).contains(board[i][j])) {
                        return false;
                    } else {
                        sqrs.get(squareindex).add(board[i][j]);
                    }
                }

                if (board[j][i] != '.') {
                    if (cols.contains(board[j][i])) {
                        return false;
                    } else {
                        cols.add(board[j][i]);
                    }
                }
            }
        }

        return true;

    }
}
