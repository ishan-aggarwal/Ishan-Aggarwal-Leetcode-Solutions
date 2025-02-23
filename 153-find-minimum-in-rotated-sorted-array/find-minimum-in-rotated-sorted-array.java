class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        if (nums[l] < nums[r]) {
            return nums[l];
        }

        int ans = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l)/2;
            int midValue = nums[mid];
            int midValueArea = getArea(nums, midValue);
            if (midValue < safeGet(nums, mid - 1) && midValue < safeGet(nums, mid + 1)) {
                return midValue;
            } else if (midValueArea == 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int getArea(int[] nums, int value) {
        if (value >= nums[0]) {
            return 1;
        }
        return 2;
    }

    public int safeGet(int[] nums, int idx) {
        if (idx >= 0 && idx < nums.length) {
            return nums[idx];
        }
        return Integer.MAX_VALUE;
    }
}