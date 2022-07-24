class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
		int columns = matrix[0].length;
		int columnIndex = columns - 1, rowIndex = 0;
		boolean isElementPresent = false;
		while (columnIndex >= 0 && rowIndex <= rows - 1) {
			if (matrix[rowIndex][columnIndex] == target) {
				isElementPresent = true;
				break;
			} else if (matrix[rowIndex][columnIndex] > target) {
				columnIndex--;
			} else {
				rowIndex++;
			}
		}
		if (isElementPresent) {
			return true;
		} else {
			return false;
		}
    }
}