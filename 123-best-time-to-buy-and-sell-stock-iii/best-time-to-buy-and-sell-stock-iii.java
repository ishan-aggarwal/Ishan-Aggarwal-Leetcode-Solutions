class Solution {
    public int maxProfit(int[] prices) {
        int k = 2; // at-most 2 transactions are allowed
        int[][][] dp = new int[prices.length][2][k + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int l = 0; l < dp[0][0].length; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return calc(prices, 0, 1, dp, k);
    }

    private static int calc(int[] prices, int index, int buy, int[][][] dp, int k) {
        // base condition
        if (index >= prices.length || k == 0) {
            return 0;
        }
        // if the value is already calculated then return it
        if (dp[index][buy][k] != -1) {
            return dp[index][buy][k];
        }

        if (buy == 1) {
            return dp[index][buy][k] = Math.max(-prices[index] + calc(prices, index + 1, 0, dp, k),
                    calc(prices, index + 1, 1, dp, k));
        } else {
            return dp[index][buy][k] = Math.max(prices[index] + calc(prices, index + 1, 1, dp, k - 1),
                    calc(prices, index + 1, 0, dp, k));
        }
    }
}