class Solution {
    public int maxAscendingSum(int[] nums) {
        int currSum = nums[0];
        int prev = nums[0];
        int ans = currSum;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr > prev) {
                currSum += curr;
            } else {
                currSum = curr;
            }
            prev = curr;
            ans = Math.max(ans, currSum);
        }
        return ans;
    }
}