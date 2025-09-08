class Solution {
    public int[] getNoZeroIntegers(int n) {
        int first = 0;
        int other = 0;
        while (!isValid(other) || !isValid(first)) {
            first++;
            other = n - first;
        }
        return new int[] {first, other};
    }

    private boolean isValid(int n) {
        if (n == 0) return false;
        while (n != 0) {
            int r = n % 10;
            if (r == 0) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }
}