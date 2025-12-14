class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        // since there are two variables in the function that are changing
        // so we are creating a 2D dp array
        int[][] dp = new int[n+1][2];

        // initialize the dp array with -1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int buy = 1; // sell = 0
        return calculateProfitUsingDP(prices, 0, buy, dp);

    }

    // using dp 
    private int calculateProfitUsingDP(int[] prices, int idx, int buy, int[][] dp) {

        // base condition
        if (idx >= prices.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }

        if (buy == 1) {
            return dp[idx][buy] = Math.max(-prices[idx] + calculateProfitUsingDP(prices, idx + 1, 0, dp), calculateProfitUsingDP(prices, idx + 1, 1, dp));
        } else {
            return dp[idx][buy] = Math.max(prices[idx] + calculateProfitUsingDP(prices, idx + 2, 1, dp), calculateProfitUsingDP(prices, idx + 1, 0, dp));
        }
    }
}