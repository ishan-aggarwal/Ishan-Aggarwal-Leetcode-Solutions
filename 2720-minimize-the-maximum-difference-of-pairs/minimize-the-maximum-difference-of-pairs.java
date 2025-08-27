class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int len = nums.length;

        long l = 0;
        long r = nums[len - 1] - nums[0];
        long ans = 0;

        while  (l <= r) {
            long mid = l + (r - l) / 2; // is the difference I am looking for
            long pairsPossible = countPairs(nums, mid);

            if (pairsPossible >= p) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ans;
    }

    private long countPairs(int[] nums, long diff) {
        long count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= diff) {
                count++;
                i++;
            }
        }
        return count;
    }
}