class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;
        
        int[] profit = new int[k+1];
        int[] cost = new int[k+1];

        profit[0] = 0;
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        for (int price: prices) {
            for (int i = 0; i < k; i++) {
                cost[i+1] = Math.min(cost[i+1], price - profit[i]);
                profit[i+1] = Math.max(profit[i+1], price - cost[i+1]);
            }
        }
        return profit[k];   
    }
}