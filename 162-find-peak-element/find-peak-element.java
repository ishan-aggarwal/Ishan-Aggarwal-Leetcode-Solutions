class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= safeGet(nums, mid - 1) && nums[mid] >= safeGet(nums, mid + 1)) {
                return mid;
            }
            if (nums[mid] >= safeGet(nums, mid - 1) && 
                        nums[mid] < safeGet(nums, mid + 1)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int safeGet(int[] nums, int pos) {
        if (pos >= 0 && pos < nums.length) {
            return nums[pos];
        }
        return Integer.MIN_VALUE;
    }
}