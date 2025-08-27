class Solution {
    public int maximumCandies(int[] candies, long k) {
        // Find the maximum pile size → upper bound of our search space
        int max = Integer.MIN_VALUE;
        for (int c : candies) {
            max = Math.max(c, max);
        }

        // Binary search over "candies per child"
        // l = minimum possible candies per child (1)
        // r = maximum possible candies per child (max pile size)
        long l = 1, r = max;
        long ans = 0; // best feasible allocation found so far

        while (l <= r) {
            long mid = l + (r - l) / 2; // trial allocation (candies per child)
            long children = countChildren(candies, mid);

            if (children >= k) {
                // Feasible: we can give at least k children "mid" candies each
                // Try to increase allocation
                ans = mid;
                l = mid + 1;
            } else {
                // Not feasible: too few children can be served with "mid" candies
                // Reduce allocation
                r = mid - 1;
            }
        }
        return (int) ans;
    }

    // Count how many children can be served if each gets "candiesPerChild" candies
    private long countChildren(int[] candies, long candiesPerChild) {
        long children = 0;
        for (int c : candies) {
            // From this pile, we can serve (c / candiesPerChild) children
            children += c / candiesPerChild;
        }
        return children;
    }
}
