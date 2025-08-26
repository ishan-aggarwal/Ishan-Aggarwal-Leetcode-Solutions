class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        int maxDiagSq = 0; // squared diagonal length

        for (int[] dim : dimensions) {
            int diagSq = dim[0] * dim[0] + dim[1] * dim[1];
            int area = dim[0] * dim[1];

            if (diagSq > maxDiagSq || 
                (diagSq == maxDiagSq && area > ans)) {
                maxDiagSq = diagSq;
                ans = area;
            }
        }
        return ans;
    }
}