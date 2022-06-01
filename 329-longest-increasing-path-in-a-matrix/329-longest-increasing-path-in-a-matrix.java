class Solution {
    
    // SC - O(M*N)
    // TC - O(M*N) - Because we are iterating over the entire matrix and visiting each cell.. Not repeating the calculations if the LIS is already computed
    // for any of the cells.
    
    public int longestIncreasingPath(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        
        int answer = 1;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                answer = Math.max( answer, dfs(r, c, matrix, -1, dp));
            }
        }
        
        return answer;
    }
    
    private static int dfs(int rowIdx, int colIdx, int[][] matrix, int prevValue, int[][] dp) {
        
        if (rowIdx < 0 || rowIdx >= matrix.length
                || colIdx < 0 || colIdx >= matrix[0].length
                || matrix[rowIdx][colIdx] <= prevValue) {
            return 0;
        }
        
        if (dp[rowIdx][colIdx] != 0) {
            return dp[rowIdx][colIdx];
        }
        
        int res = 1;
        res = Math.max(res, 1 + dfs(rowIdx + 1, colIdx, matrix, matrix[rowIdx][colIdx], dp));
        res = Math.max(res, 1 + dfs(rowIdx - 1, colIdx, matrix, matrix[rowIdx][colIdx], dp));
        res = Math.max(res, 1 + dfs(rowIdx, colIdx + 1, matrix, matrix[rowIdx][colIdx], dp));
        res = Math.max(res, 1 + dfs(rowIdx, colIdx - 1, matrix, matrix[rowIdx][colIdx], dp));
        
        dp[rowIdx][colIdx] = res;
        return res;
    }
}