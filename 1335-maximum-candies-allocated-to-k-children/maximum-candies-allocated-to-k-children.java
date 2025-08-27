class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        for (int c : candies) {
            max = Math.max(c, max);
        }

        // search space 
        // because I can distribute minimum 1 candy to each children
        // and in order to ensure maximize the candies - that we are setting to the max of all
        // if it is feasible, otherwise our binary search will ensure it does not allow it
        long l = 1, r = max;
        long ans = 0;
        while (l <= r) {
            long mid =  l + (r - l) / 2; // trial candies per child
            long children = countChildren(candies, mid);
            // means mid candies I am able to give to more than k children
            // feasible → try more candies
            if (children >= k) {
                ans = mid;
                l = mid + 1; // I should try to increase the number of candies
            } else {
                // not feasible → try less candies distribution 
                r = mid - 1; // it is not possible to distribute those many candies so I should try to reduce
            }
        }
        return (int) ans;
    }

    private long countChildren(int[] candies, long candiesPerChild) {
        long children = 0;
        for (int c : candies) {
            children += c / candiesPerChild; // how many children can this pile serve
        }
        return children;
    }
}