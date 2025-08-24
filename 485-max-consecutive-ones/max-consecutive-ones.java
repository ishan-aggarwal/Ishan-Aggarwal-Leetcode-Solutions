class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentCount = 0;
        int ans = 0;
        for (int ele : nums) {
            if (ele == 1) {
                currentCount++;
            }
            ans = Math.max(currentCount, ans);
            if (ele == 0) {
                currentCount = 0;
            }
        }
        return ans;
    }
}