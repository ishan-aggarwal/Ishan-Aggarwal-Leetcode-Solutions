class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        double maxDiagonalLength = 0d;

        for (int[] dim : dimensions) {
            double diag = Math.sqrt(dim[0] * dim[0] + dim[1] * dim[1]);
            int area = dim[0] * dim[1];

            if (diag > maxDiagonalLength || 
                (diag == maxDiagonalLength && area > ans)) {
                maxDiagonalLength = diag;
                ans = area;
            }
        }
        return ans;
    }
}