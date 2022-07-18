class Solution {
    static byte[] map = new byte[20_000_001];
    static final int BASE_SUM = -10_000_000;
    
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rowLastIdx = matrix.length - 1;
        int colLastIdx = matrix[0].length - 1;
        int result = 0;
        
        // Copy the original int[][] matrix a the colSums[][] matrix.  This 
        // matrix will be used to build some running sums along the rows.  If the 
        // matrix is taller than it is wide, then also transpose the matrix to make 
        // the width the long dimension.  Sum all the columns in each row, starting 
        // at the rightmost column (highest numbered column) and summing to the left 
        // (summing to column 0).  Then each cell in the colSums[][] matrix will be 
        // the sum of all cell values to the right on the same row.
        int[][] colSums;
        if (rowLastIdx <= colLastIdx) {                 // Height <= width
            colSums = new int[rowLastIdx + 1][colLastIdx + 2];
            for (int row = 0; row <= rowLastIdx; row++) {
                int sum = 0;
                for (int col = colLastIdx; col >= 0; col--)
                    sum = colSums[row][col] = sum + matrix[row][col];
            }            
        } else {                                        // Height > width.  Transpose.
            int temp = colLastIdx;
            colLastIdx = rowLastIdx;
            rowLastIdx = temp;
            colSums = new int[rowLastIdx + 1][colLastIdx + 2];
            for (int row = 0; row <= rowLastIdx; row++) {
                int[] curSumRow = colSums[row];
                int sum = 0;
                for (int col = colLastIdx; col >= 0; col--)
                    sum = curSumRow[col] = sum + matrix[col][row];
            }            
        }

        // Loop through all possible sub matrixes, to see if the sum is the target.  All 
        // columns have already been summed on each row, so that each cell in colSums[][] 
        // matrix is the sum of all cells to the right on the same row.  Then for a given 
        // starting column of a submatrix, and a given width of the submatrix, 
        int[] curRowSums = new int[rowLastIdx + 2];
        for (int startCol = colLastIdx; startCol >= 0; startCol--) {
            for (int colWidth = colLastIdx - startCol + 1; colWidth > 0; colWidth--) {
                int sum = -BASE_SUM;
                map[target - BASE_SUM] = 1;
                curRowSums[rowLastIdx + 1] = target - BASE_SUM;
                for (int row = rowLastIdx; row >= 0; row--) {
                    sum += colSums[row][startCol] - colSums[row][startCol + colWidth];
                    result += map[sum];
                    map[sum + target]++;
                    curRowSums[row] = sum + target;
                }
                for (int row = rowLastIdx + 1; row >= 0; row--)
                    map[curRowSums[row]] = 0;
            }
        }
        
        return result;
    }

}