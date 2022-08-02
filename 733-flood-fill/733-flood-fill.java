class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColor = image[sr][sc];
        if (currentColor != newColor) dfs(image, sr, sc, currentColor, newColor);
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int currentColor, int newColor) {

        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != currentColor) {
            return;
        }
        
        if (image[sr][sc] == newColor) {
            return;
        }
        
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, currentColor, newColor);
        dfs(image, sr, sc + 1, currentColor, newColor);
        dfs(image, sr - 1, sc, currentColor, newColor);
        dfs(image, sr, sc - 1, currentColor, newColor);
    }
}