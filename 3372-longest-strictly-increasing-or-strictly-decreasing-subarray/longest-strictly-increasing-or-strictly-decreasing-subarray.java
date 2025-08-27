class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int incCount = 1;
        int decCount = 1;
        int prev = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr > prev) {
                incCount++;
                decCount = 1;
            } else if (curr < prev) {
                decCount++;
                incCount = 1;
            } else {
                incCount = 1;
                decCount = 1;
            }
            ans = Math.max(ans, Math.max(incCount, decCount));
            prev = curr;
        }
        return ans;
    }
}