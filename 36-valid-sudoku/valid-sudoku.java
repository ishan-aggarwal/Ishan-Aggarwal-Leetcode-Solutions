class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
		int m = board[0].length;
        
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (!isValid(board, i, j)) {
					return false;
				}
			}
		}
        return true;
    }
    
    private static boolean isValid(char[][] A, int row, int col) {
		return notInRow(A, row) && notInColumn(A, col) && notInBox(A, row - row % 3, col - col % 3);
	}

	private static boolean notInRow(char[][] A, int row) {
		Set<Character> rowSet = new HashSet<>();
		char[] string = A[row];
		int colSize = string.length;

		for (int j = 0; j < colSize; j++) {
			char data = string[j];
			if (rowSet.contains(data)) {
				return false;
			} else if (data != '.') {
				rowSet.add(data);
			}
		}
		return true;
	}
    
    private static boolean notInColumn(char[][] A, int col) {
		Set<Character> colSet = new HashSet<>();
		int rowSize = A.length;
		for (int i = 0; i < rowSize; i++) {
			char data = A[i][col];
			if (colSet.contains(data)) {
				return false;
			} else if (data != '.') {
				colSet.add(data);
			}
		}
		return true;
	}

    private static boolean notInBox(char[][] A, int startRow, int startColumn) {
		Set<Character> set = new HashSet<>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				char data = A[row + startRow][col + startColumn];
				if (set.contains(data)) {
					return false;
				} else if (data != '.') {
					set.add(data);
				}
			}
		}
		return true;
	}
}