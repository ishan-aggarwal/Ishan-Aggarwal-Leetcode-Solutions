class Solution {
    public int majorityElement(int[] nums) {
        Integer ans = null;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (ans == null) {
                ans = nums[i];
                count = 1;
            } else if (nums[i] == ans) {
                count++;
            } else if (nums[i] != ans) {
                count--;
            }

            if (count == 0) {
                ans = null;
            }
        }
        return ans;
    }
}