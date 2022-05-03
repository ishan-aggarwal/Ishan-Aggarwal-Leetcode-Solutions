class Solution {
    public int numSquares(int n) {
        
        if (n <= 3) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for (int num = 4; num <= n; num++) {
            
            for (int i = 1; i <= Math.sqrt(num); i++) {
                dp[num] = Math.min(dp[num], 1 + dp[num - i * i]);    
            }
        }
        
        return dp[n];
    }
}