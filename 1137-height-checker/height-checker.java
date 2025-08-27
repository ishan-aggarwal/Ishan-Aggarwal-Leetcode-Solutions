class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] expected = new int[n];
        int idx = 0;
        for (int ele : heights) {
            expected[idx++] = ele;
        }
        Arrays.sort(expected);
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != expected[i]) {
                diff++;
            }
        }
        return diff;
    }
}