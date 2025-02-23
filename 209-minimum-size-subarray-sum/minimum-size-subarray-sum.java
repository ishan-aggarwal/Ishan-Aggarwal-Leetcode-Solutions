class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        
        while (right < n) {
            int value = nums[right];
            sum += value;
            while (sum >= target) {
                if (sum >= target) {
                    ans = Math.min(ans, right - left + 1); // 4
                }
                int leftValue = nums[left];
                sum -= leftValue;
                left++;
            }

            right++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}