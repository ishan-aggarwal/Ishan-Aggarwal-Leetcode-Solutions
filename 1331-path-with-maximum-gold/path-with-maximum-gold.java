class Solution {
    private int maxGold = 0;
    
    // Array to represent the four possible movements (right, left, down, up)
    private final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

   
    public int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int R = grid.length;
        int C = grid[0].length;
        maxGold = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] > 0) {
                   
                    int currentPathGold = dfs(grid, r, c);
                    maxGold = Math.max(maxGold, currentPathGold);
                }
            }
        }
        
        return maxGold;
    }

   
    private int dfs(int[][] grid, int r, int c) {
        
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
       int gold = grid[r][c];
        grid[r][c] = 0; 

        int maxNextGold = 0;
        for (int[] dir : DIRS) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            maxNextGold = Math.max(maxNextGold, dfs(grid, nextR, nextC));
        }

       grid[r][c] = gold; 

        return gold + maxNextGold;
    }

}