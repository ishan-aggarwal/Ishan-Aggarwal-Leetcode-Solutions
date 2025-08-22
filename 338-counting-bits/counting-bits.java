class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];        
        for (int num = 0; num <= n; num++) {
            int countBits = 0;
            for (int bit = 0; bit < 32; bit++) {
                if ((num & (1 << bit)) > 0) {
                    countBits++;
                }
            }
            ans[num] = countBits;
        }
        return ans;
    }
}