class Solution {
    public int divide(int dividend, int divisor) {

        // If dividend is zero, return zero directly.
        if (dividend == 0) {
            return 0;
        }

        // To let our strategy to work, we should handle the case if divisor is INT_MIN.
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }

        // Use exclusive or to check the sign of answer.
        boolean is_pos = (dividend > 0) ^ (divisor < 0);
        int ans = 0;

        // Here is different from the description above.
        // In practice, we force our dividend to be negative.
        // Because the range of negative values (2^31) is larger than the range of positive values (2^31 - 1).
        // If we force dividend to be positive, there may be integer overflow.
        if (dividend > 0) {
            dividend = 0 - dividend;
        }

        // Divisor should be positive.
        // Because we will apply bitwise shift to it.
        // And we have handled the case when divisor is INT_MIN.
        if (divisor < 0) {
            divisor = 0 - divisor;
        }

        // To compare negative dividend and positive divisor, we need to add negative sign to divisor.
        while (dividend <= -divisor) {
            int tmp = divisor;
            int step = 1;

            // "tmp < 0x40000000" is a trick. 0x40000000 is 2^30.
            // If we don't limit the upper bound, tmp may keep shifting and lead an integer overflow.
            while (tmp < 0x40000000 && -tmp > dividend) {
                tmp <<= 1;
                step <<= 1;
            }

            // Here we find the largest divisor.
            if (-tmp < dividend) {
                tmp >>= 1;
                step >>= 1;
            }

            dividend += tmp;

            // Another trick is that using minus instead of using add.
            // The same reason as above: the range of negative values is larger than the range of positive values.
            ans -= step;
        }

        if (!is_pos) {
            return ans;
        } else {
            return ans == Integer.MIN_VALUE ? Integer.MAX_VALUE : -ans;
        }

        
    }
}