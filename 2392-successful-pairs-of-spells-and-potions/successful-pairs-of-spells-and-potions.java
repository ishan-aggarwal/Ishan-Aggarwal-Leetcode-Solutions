class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // m*logm
        int cnt = 0;
        int[] output = new int[spells.length];
        for (long num : spells) { // o(n)
            int l = 0, r = potions.length - 1;
            int ans = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                long other = potions[mid];
                if (other * num >= success) {
                    r = mid - 1;
                    ans = potions.length - mid;
                } else {
                    l = mid + 1;
                }
            }
            output[cnt++] = ans;
        }
        return output;
    }
}