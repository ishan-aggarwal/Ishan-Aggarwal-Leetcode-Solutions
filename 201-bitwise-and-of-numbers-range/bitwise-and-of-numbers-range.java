class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int totalShifts = 0;
        while (left < right) {
            left = left >> 1;
            right = right >> 1;
            totalShifts++;
        }
        return left << totalShifts;
    }
}