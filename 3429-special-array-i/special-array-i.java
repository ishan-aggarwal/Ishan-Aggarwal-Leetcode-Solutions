class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int ele1 = nums[i];
            int ele2 = nums[i + 1];
            if ((ele1 % 2 == 0 && ele2 % 2 == 0) || (ele1 % 2 == 1 && ele2 % 2 == 1)) {
                return false;
            }
        }
        return true;
    }
}