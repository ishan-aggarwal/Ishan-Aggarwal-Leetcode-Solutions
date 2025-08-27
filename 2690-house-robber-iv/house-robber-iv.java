class Solution {
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int l = min; // The smallest possible capability is the minimum value in nums
        int r = max; // The largest possible capability is the maximum value in nums
        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            // Determine if it's possible to rob at least k houses with a maximum capability of mid
            int houses = countHouses(nums, mid);
            if (houses >= k) {
                ans = mid;
                r = mid - 1; // search left for smaller capability (Q says:: minimum capability of the robber)
            } else {
                l = mid + 1; // try with large capability to atleast rob k houses
            }
        }
        return ans;
    }

    private int countHouses(int[] nums, int capability) {
        int count = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] <= capability) { // robber can rob if capability is the max
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count;
    }
}
