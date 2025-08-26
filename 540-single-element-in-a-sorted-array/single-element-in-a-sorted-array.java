class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] != safeGet(nums, mid - 1) && nums[mid] != safeGet(nums, mid + 1)) {
               return nums[mid]; 
            }
            int fo = mid;
            if (nums[mid] == safeGet(nums, mid - 1)) {
                fo = mid - 1;
            }

            if (fo % 2 == 0) {
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
        return Integer.MAX_VALUE;
    }
}