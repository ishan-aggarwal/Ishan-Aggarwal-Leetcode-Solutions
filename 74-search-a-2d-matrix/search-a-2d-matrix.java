class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0, c = cols - 1;
        while (r < rows && c >= 0) {
            int ele = matrix[r][c];
            if (ele == target) {
                return true;
            } else if (ele > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}