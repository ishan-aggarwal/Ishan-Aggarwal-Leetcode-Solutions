class Solution {

    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums, n - 1);
    }

    public int solve(int[] nums, int idx) {
        if (idx < 0) {
            return 0;
        }
        if (dp[idx] != -1) return dp[idx];
        int dont = solve(nums, idx - 1);
        int take = nums[idx] + solve(nums, idx - 2);
        dp[idx] = Math.max(dont, take);
        return dp[idx];
    }
}