class Solution {
    public int minPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[][] dp = new int[n][m];

        dp[0][0] = A[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + A[i][0];
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + A[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }
}