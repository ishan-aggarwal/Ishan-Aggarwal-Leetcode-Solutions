class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    
    private boolean solve(char[][] board, int row, int col) {
        
        if (row == 9) {
            return true;
        }
        
        if (board[row][col] == '.') {
            for (int num = 1; num <= 9; num++) {
                
                char get = (char) (num + '0');
                if (isSafe(board, row, col, get)) {
                    
                    // set the current char at the position
                    board[row][col] = get;
                    if (col == 8) {
                        boolean ans = solve(board, row + 1, 0);
                        if (ans)
                            return true;                
                    } else {
                        boolean ans = solve(board, row, col + 1);
                        if (ans)
                            return true;
                    }
                    // unset the character
                    board[row][col] = '.';
                }
            }
        } else {
            if (col == 8) {
                boolean ans = solve(board, row + 1, 0);
                if (ans)
                    return true;                
            } else {
                boolean ans = solve(board, row, col + 1);
                if (ans)
                    return true;
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char target) {
        
        // check for all cols in given row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == target) {
                return false;
            }
        }
        
        // check for all rows with column col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == target) {
                return false;
            }
        }
        
        // check for 3*3 matrix
        int i = (row / 3) * 3;
        int j = (col / 3) * 3;
        
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (board[k + i][l + j] == target) {
                    return false;
                }
            }
        }
        return true;
    }
}