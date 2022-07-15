class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }
    
    public int dfs(int[][] grid, int rIdx, int cIdx) {
        if (rIdx < 0 || rIdx >= grid.length || cIdx < 0 || cIdx >= grid[0].length || grid[rIdx][cIdx] == 0) {
            return 0;
        }
        grid[rIdx][cIdx] = 0;
        int count = 1;
        count += dfs(grid, rIdx + 1, cIdx);
        count += dfs(grid, rIdx, cIdx + 1);
        count += dfs(grid, rIdx - 1, cIdx);
        count += dfs(grid, rIdx, cIdx - 1);
            
        return count;
    }
}