class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for (int ele : arr) {
            freq[ele]++;
        }
        int ans = -1;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == i) {
                ans = i;
            }
        }
        return ans;
    }
}