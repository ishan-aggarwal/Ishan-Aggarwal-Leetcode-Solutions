class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = Integer.MIN_VALUE;
        for (int ele : nums) {
            max = Math.max(max, ele);
        }
        long l = 1, r = max;
        long ans = 0;
        // Binary search on maximum bag size
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long possibleOperations = countOperations(nums, mid);
            if (possibleOperations <= maxOperations) {
                // Feasible: try smaller bag size
                ans = mid;
                r = mid - 1;
            } else {
                // Not feasible: need bigger bag size
                l = mid + 1;
            }
        }
        return (int) ans;
    }

    private long countOperations(int[] nums, long mid) {
        long ops = 0;
        for (int balls : nums) {
            if (balls > mid) {
                ops += (balls + mid - 1) / mid - 1; // ceil(balls/mid) - 1
            }
        }
        return ops;
    }
}