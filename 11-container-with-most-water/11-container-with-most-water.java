class Solution {
    
    // TC - O(N) and SC - O(1)
    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            
            int current = (j - i) * Math.min(height[i], height[j]);
            ans = Math.max (ans, current);
            if (height[i] < height[j]) {
                i++;
            } else if (height[i] > height[j]) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return ans;
    }
}