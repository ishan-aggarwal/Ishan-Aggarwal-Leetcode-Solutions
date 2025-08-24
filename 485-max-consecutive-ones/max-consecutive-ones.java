class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentCount = 0;
        int ans = 0;
        for (int ele : nums) {
            if (ele == 1) {
                currentCount++;
            } else {
                currentCount = 0;
            }
            ans = Math.max(currentCount, ans);
        }
        return ans;
    }
}