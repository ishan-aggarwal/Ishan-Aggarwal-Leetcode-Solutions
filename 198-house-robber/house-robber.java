class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int secondPrev = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int take = nums[i] + secondPrev;
            int dont = prev;

            secondPrev = prev;
            prev = Math.max(take, dont);
        }

        return prev;
    }
}