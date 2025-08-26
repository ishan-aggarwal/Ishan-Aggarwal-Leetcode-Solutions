class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long sq = mid * mid;
            if (sq == num) {
                return true;
            }
            if (sq > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}