class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            int price = prices[i];
            if (price < buyPrice) {
                buyPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - buyPrice);
            }
        }
        return maxProfit;
    }
}