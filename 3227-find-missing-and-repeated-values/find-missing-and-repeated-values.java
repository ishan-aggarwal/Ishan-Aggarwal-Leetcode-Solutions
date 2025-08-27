class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        Set<Integer> seen = new HashSet<>();
        int n = grid.length;
        int range = n * n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ele = grid[i][j];
                if (seen.contains(ele)) {
                    res[0] = ele;
                }
                seen.add(ele);
            }
        }

        for (int i = 1; i <= range; i++) {
            if (!seen.contains(i)) {
                res[1] = i;
            }
        }

        return res;
    }
}