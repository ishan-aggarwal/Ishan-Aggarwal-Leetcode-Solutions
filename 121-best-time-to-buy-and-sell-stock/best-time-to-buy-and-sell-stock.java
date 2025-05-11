class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int buyPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - buyPrice);
            }
        }
        return ans;
    }
}