class Solution {
    public int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;
        int l = 0, r = height.length - 1;

        while (l < r) {
            int w = r - l;
            ans = Math.max(ans, Math.min(height[l], height[r]) * w);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }
}