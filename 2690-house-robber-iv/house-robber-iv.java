class Solution {
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int l = min;
        int r = max;
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int houses = countHouses(nums, mid);
            if (houses >= k) {
                ans = mid;
                r = mid - 1; // search left for smaller capability
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private int countHouses(int[] nums, int capability) {
        int count = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] <= capability) { // careful: capability is the max he can steal
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count;
    }
}
