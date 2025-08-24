class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0, n = nums.length, ans = 0, zeroCount = 0;
        while (j < n) {
            if (nums[j] == 1) {
                ans = Math.max(ans, j - i);
                j++;
            } else {
                zeroCount++;
                while (zeroCount > 1) {
                    if (nums[i] == 0) {
                        zeroCount--;
                    }
                    i++;
                }
                ans = Math.max(ans, j - i);
                j++;
            }
        }
        return ans;
    }
}