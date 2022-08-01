class Solution {
    public int uniquePaths(int m, int n) {
        
        // base case if there is only 1 row or 1 column
        if (m == 0 || n == 0) {
            return 1;
        }
        
        // take a matrix to store the dp states
        int[][] dpState = new int[m][n];
        
        // fill the first col with 1
        for (int i = 0; i < m; i++) {
            dpState[i][0] = 1;        
        }
        
        // fill the first row with 1
        for (int j = 0; j < n; j++) {
            dpState[0][j] = 1;
        }
        
        
        // iterate over the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                
                // dp expression
                // where dp[i][j] represents the unique ways to reach i,j using i-1,j or i,j-1
                dpState[i][j] = dpState[i - 1][j] + dpState[i][j - 1];
            }
        }
        
        // return ans
        return dpState[m - 1][n - 1];
    }
    
    // Space optimized solution
    // Runtime: O(M*N) Memory: O(N)
    // public int uniquePaths(int m, int n) {
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, 1);
    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             dp[j] = dp[j] + dp[j - 1];
    //         }
    //     }
    //     return dp[n - 1];
    // }
    
}