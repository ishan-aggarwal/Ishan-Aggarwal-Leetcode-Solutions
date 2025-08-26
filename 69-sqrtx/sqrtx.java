class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x;
        long ans = 0;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long sq = mid * mid; 
            if (sq <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) ans;
    }
}