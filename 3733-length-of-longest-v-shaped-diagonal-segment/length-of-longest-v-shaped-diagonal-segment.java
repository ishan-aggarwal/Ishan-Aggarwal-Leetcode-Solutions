class Solution {
    int n, m; // dimensions of the grid
    int[][][][] dp; // memoization array to store results of DFS to avoid recomputation
    int[][] d; // stores the movement offsets for the 4 diagonal directions
    int[][] grid;
    public int lenOfVDiagonal(int[][] grid) {

        // Stores the input grid and dimensions into class-level variables.
        // Initializes dp array to store memoized results.
        // Sets up direction offsets.
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        this.dp = new int[n][m][4][2];
        this.d = new int[][] { {1, 1}, {1, -1}, {-1, -1}, {-1, 1} };

        // Initialize dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 2; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        int ans = 0;
        // Loops over each cell (i,j) in the grid.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Only start from cells with 1 
                // V-shaped diagonal segment starts with 1
                if (grid[i][j] == 1) {
                    // Tries all 4 directions (k) for the first leg of the V.
                    for (int k = 0; k < 4; k++) {
                        // Calls DFS to compute the longest V starting here.
                        int res = dfs(i, j, k, true, 2);
                        // Updates ans with the maximum length found.
                        // The +1 here adds the starting cell (i,j) to the length.
                        ans = Math.max(ans, res + 1);
                    }
                }
            }
        }
        return ans;
    }

    /**
        x, y → current cell.
        dir → current diagonal direction.
        turn → whether we can still make the turn in the V (true if not yet used).
        next → expected value in the next cell (here 2 or 0, your solution flips it using 2 - next).
    */
    private int dfs(int x, int y, int dir, boolean turn, int next) {
        // Move in the current diagonal direction to get the next cell.
        int nx = x + d[dir][0];
        int ny = y + d[dir][1];

        // base case
        // If the next cell is out of bounds or does not contain the expected value (next), stop recursion
        // Return 0 because no further V segment can extend.
        if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] != next) {
            return 0;
        }

        // DP stores results separately for “turn available” vs “turn used.”
        // If turn is true, index = 1; otherwise = 0.
        int tIdx = turn ? 1 : 0;

        // If DFS for this cell, direction, and turn status has already been computed, return it.
        if (dp[nx][ny][dir][tIdx] != -1) {
            return dp[nx][ny][dir][tIdx];
        }

        // Continue moving in the same direction, flipping the expected value.
        int res = dfs(nx, ny, dir, turn, 2 - next);

        // If turn is still available, try making the turn (change diagonal direction).
        // After turn, set turn=false because we can only turn once in a V.
        // Take Math.max to consider both possibilities: keep going in same direction or turn once.
        if (turn) {
            res = Math.max(res, dfs(nx, ny, (dir + 1) % 4, false, 2 - next));
        }
        
        // Add 1 for the current step.
        // Store the result in DP for memoization.
        dp[nx][ny][dir][tIdx] = res + 1;

        // Return the computed length.
        return dp[nx][ny][dir][tIdx];
    }
}