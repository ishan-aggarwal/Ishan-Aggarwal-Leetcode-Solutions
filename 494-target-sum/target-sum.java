class Solution {
    
    private int[][] dp;
    
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int ele : nums) {
            total += ele;
        }

        if (total < Math.abs(target) || (total + target) % 2 != 0) {
            return 0;
        }


        int n = nums.length;

        // s1 + s2 = total
        // s1 - s2 = target 
        // 2 * s1 = total + target
        // s1 = ( total + target )  / 2;

        int expected = (total + target) / 2;
        dp = new int[n + 1][expected + 1];
        
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        solve(nums, expected, n);
        return dp[n][expected];
    }

    private int solve(int[] nums, int expected, int n) {
        if (n == 0) {
            if (expected == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[n][expected] != -1) {
            return dp[n][expected];
        }

        if (nums[n - 1] <= expected) {
            dp[n][expected] = solve(nums, expected, n - 1) + solve(nums, expected - nums[n - 1], n - 1);
        } else {
            dp[n][expected] = solve(nums, expected, n - 1); 
        }
        return dp[n][expected];
    }
}