class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;

        int currentRow = 0, currentCol  = totalCols - 1;

        while (currentRow < totalRows && currentCol >= 0) {
            int value = matrix[currentRow][currentCol];
            if (target == value) {
                return true;
            } else if (target < value) {
                currentCol--;
            } else {
                currentRow++;
            }
        }

        return false;
    }
}