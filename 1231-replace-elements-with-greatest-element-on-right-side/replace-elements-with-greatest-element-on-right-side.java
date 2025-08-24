class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] rMax = new int[n];
        
        rMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], arr[i]);
        }
        // 18, 18, 6, 6, 6, 1
        int[] ans = new int[n];
        ans[n - 1] = -1;
        
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = rMax[i + 1];
        }
        return ans;
    }
}