class Solution {
    int n, m;
    int[][][][] dp;
    int[][] d;
    int[][] grid;
    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;
        this.dp = new int[n][m][4][2];
        this.d = new int[][] { {1, 1}, {1, -1}, {-1, -1}, {-1, 1} };

        // default dp array to -1
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // possible start in grid
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int res = dfs(i, j, k, true, 2);
                        ans = Math.max(ans, res + 1);
                    }
                }
            }
        }
        return ans;
    }

    private int dfs(int x, int y, int dir, boolean turn, int next) {
        int nx = x + d[dir][0];
        int ny = y + d[dir][1];

        // base case
        if (nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] != next) {
            return 0;
        }

        int tIdx = turn ? 1 : 0;

        // if ans is already available return
        if (dp[nx][ny][dir][tIdx] != -1) {
            return dp[nx][ny][dir][tIdx];
        }

        int res = dfs(nx, ny, dir, turn, 2 - next);
        if (turn) {
            res = Math.max(res, dfs(nx, ny, (dir + 1) % 4, false, 2 - next));
        }
        
        dp[nx][ny][dir][tIdx] = res + 1;
        return dp[nx][ny][dir][tIdx];
    }
}