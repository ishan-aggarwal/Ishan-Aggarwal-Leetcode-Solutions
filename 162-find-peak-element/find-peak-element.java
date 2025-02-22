class Solution {
    public int findPeakElement(int[] nums) {
        int length = nums.length;

        if (length == 1) {
            return 0;
        } else if (length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }

        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > safeGet(nums, mid - 1) && nums[mid] > safeGet(nums, mid + 1)) {
                return mid;
            } else if (nums[mid] > safeGet(nums, mid - 1) && nums[mid] < safeGet(nums, mid + 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public int safeGet(int[] nums, int index) {
        if (index >= 0 && index < nums.length) {
            return nums[index];
        }
        return Integer.MIN_VALUE;
    }
}