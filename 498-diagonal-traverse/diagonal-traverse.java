class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[] res = new int[rows * cols];
        int idx = 0;

        for (int s = 0; s < rows + cols - 1; s++) {
            if (s % 2 == 0) {
                int i = Math.min(s, rows - 1);
                int j = s - i;
                while(i >= 0 && j < cols) {
                    res[idx++] = mat[i][j];
                    i--;
                    j++;
                }
            } else {
                int j = Math.min(s, cols - 1);
                int i = s - j;
                while (i < rows && j >= 0) {
                    res[idx++] = mat[i][j];
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}