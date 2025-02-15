class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int n = nums.length;
        int currSum = 0;

        while (r < n) {
            currSum += nums[r]; // 9

            // i need to check if my 
            // current sum is greater than or equal to
            // the target
            // then i can possibly find an answer

            while (currSum >= target) {
                int currLength = r - l + 1; //2
                if (currLength < ans) {
                    ans = currLength; // 2
                }
                currSum -= nums[l];
                l++;
            }
            r++; // r = 5
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}