class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // minimum cost of first two stairs would be the cost of 
        // getting to that stair it self, becuase, cost is positive, 
        // so if for second step, it would be minimal if you jump directly to it.
        int f = cost[0];
        int s = cost[1];
        
        // edge case when there are two stairs, return the minimum.
        if(n <= 2) return Math.min(f, s);
        
        // calculate the cost of climibing up the stair as
        
        int curr;
        for(int i = 2; i < n; i++) {
            // toatl_cost(stair n) = cost(stair n) + min(total_cost(stair n - 1), total_cost(stair n - 2))
            curr = cost[i] + Math.min(f, s);
            
            // now for next iteration update the n-2 pointer with n - 1 cost
            f = s;
            // n - 1 with n
            s = curr;
        }
        
        return Math.min(f, s);

    }
}