class Solution {
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }

            if (nums[i] < min) {
                min = nums[i];
            }
        }

        // search space
        long l = min;
        long r = max;
        long ans = 0;
        while (l <= r) {
            // The capability of the robber is the maximum 
            // amount of money he steals from one house of all the houses he robbed.
            long mid = l + (r - l) / 2; 
            long houses = countHouses(nums, mid);
            if (houses >= k) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;               
            }
        }
        return (int) ans;
    }

    private long countHouses(int[] nums, long capability) {
        int i = 0;
        long count = 0;
        for (; i < nums.length; ) {
            if (nums[i] <= capability) {
                count++;
                i += 2;
            } else {
                i += 1;
            }
        }
        return count;
    }
}