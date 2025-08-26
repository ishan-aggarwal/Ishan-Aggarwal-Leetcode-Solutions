class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Minimum speed must be at least 1 banana/hour
        // Suppose the largest pile has M bananas. If Koko eats M bananas per hour, she can finish that pile in 1 hour.
        int l = 1, r = getMax(piles);
        int ans = r;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long hours = countHours(piles, mid);
            if (hours <= h) {
                ans = mid;        // possible answer
                r = mid - 1;      // try smaller speed
                // because Return the minimum integer k such that she can eat all the bananas within h hours.
            } else {
                l = mid + 1;      // need larger speed to eat all bananas within h hours.
            }
        }
        return ans;
    }


    private long countHours(int[] piles, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / speed);
        }
        return hours;
    }

    private int getMax(int[] piles) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }
}