class Solution {
    public int maxProfit(int k, int[] prices) {
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
        // where the index reached the end or no transactions are allowed to be performed
        if (index >= prices.length || k == 0) {
            return 0;
        }
        // if the value is already calculated then return it
        if (dp[index][buy][k] != -1) {
            return dp[index][buy][k];
        }

        // since we want to buy first
        if (buy == 1) {
            // if we decide to buy then we add -ve value , move to next index and next we want to sell or
            // it we don't decide to buy so we move to next index, along with still buy plan
            return dp[index][buy][k] = Math.max(-prices[index] + calc(prices, index + 1, 0, dp, k),
                    calc(prices, index + 1, 1, dp, k));
        } else {
            // if we decide to sell now, then we add +ve value, move to next index and next is to buy and also reduce k by 1 as one transaction is done
            // or if we have not sold, then we move to next index and still want to sell it with the same value of k
            return dp[index][buy][k] = Math.max(prices[index] + calc(prices, index + 1, 1, dp, k - 1),
                    calc(prices, index + 1, 0, dp, k));
        }
    }
}