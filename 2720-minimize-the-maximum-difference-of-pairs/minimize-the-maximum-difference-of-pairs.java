import java.util.Arrays;

class Solution {
    public int minimizeMax(int[] nums, int p) {
        // Step 1: Sort the array to consider adjacent elements for pairing
        Arrays.sort(nums);
        int len = nums.length;

        // Step 2: Define the search space for binary search
        long l = 0; // minimum possible difference
        long r = nums[len - 1] - nums[0]; // maximum possible difference
        long ans = 0; // variable to store the result

        // Step 3: Binary search to find the minimum possible maximum difference
        while (l <= r) {
            long mid = l + (r - l) / 2; // candidate maximum difference
            long pairsPossible = countPairs(nums, mid); // check how many pairs can be formed with this max difference

            if (pairsPossible >= p) {
                // If we can form at least p pairs, this difference is feasible
                ans = mid; // store current feasible difference
                r = mid - 1; // try to find a smaller maximum difference
            } else {
                // If not enough pairs, increase the allowed difference
                l = mid + 1;
            }
        }
        return (int) ans; // final minimum maximum difference
    }

    // Helper function to count the number of pairs possible with a given maximum difference
    private long countPairs(int[] nums, long diff) {
        long count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // Check if adjacent elements can form a valid pair
            if (nums[i + 1] - nums[i] <= diff) {
                count++;
                i++; // Skip next element as it's already paired
            }
        }
        return count;
    }
}
