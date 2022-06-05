class Solution {
	public boolean exist(char[][] board, String word) {

		// lets get the dimension first
		// we will use DFS as it helps to find the path quickly
		int rows = board.length;
		int cols = board[0].length;

		// now run dfs from each cell and mark visited
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				boolean isWordFound = dfs(i, j, board, word, 0);
				if (isWordFound)
					return true;
			}
		}
		return false;
	}

	private boolean dfs(int row, int column, char[][] board, String word, int curIndex) {

		// base case
		if (curIndex >= word.length()) {
			return true;
		}

		// invalid case
		if (row < 0 || row >= board.length || column < 0 || column >= board[0].length
				|| board[row][column] != word.charAt(curIndex)) {
			return false;
		}

		// mark current path visited
		board[row][column] = '#';

		// DFS Explore
		boolean isMatched = dfs(row, column + 1, board, word, curIndex + 1)
				|| dfs(row, column - 1, board, word, curIndex + 1) || dfs(row + 1, column, board, word, curIndex + 1)
				|| dfs(row - 1, column, board, word, curIndex + 1);

		if (!isMatched) {
			// reset to original state
			board[row][column] = word.charAt(curIndex);
		}

		return isMatched;
	}

}