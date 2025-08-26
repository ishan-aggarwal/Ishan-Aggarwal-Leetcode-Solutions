class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long sum = 0;
        int max = Integer.MIN_VALUE;

        for (int w : weights) {
            sum += w;
            if (w > max) {
                max = w;
            }
        }

        // we would like to have the lower bound and upper bound as below
        long l = max; // at least the heaviest package
        long r = sum; // at most all in one day
        long ans = r;

        while (l <= r) {
            long mid = l + (r - l) / 2; // mid is like my ship capacity
            long d = countDays(weights, mid);

            // feasible → try smaller capacity
            if (d <= days) { // if we are able to achieve the target
            // we would like to reduce the weight capacity 
            // so we are decreasing r
                ans = mid;
                r = mid - 1;
            } else {
                // not feasible → need bigger capacity
                // we would have to further increase the capacity as 
                // current ship capacity is not able to give us the answer
                l = mid + 1;
            }
        }
        return (int) ans;
    }

    private long countDays(int[] weights, long capacity) {
        long days = 1; // at least one day
        long currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                // need a new day because this package doesn’t fit
                days++;
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return days;
    }
}