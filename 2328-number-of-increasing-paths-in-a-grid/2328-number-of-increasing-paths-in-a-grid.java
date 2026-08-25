class Solution {
    long dfs(int[][] grid, int i, int j, int m, int n, long[][] dp, long mod) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int[] di = { -1, 0, 1, 0 };
        int[] dj = { 0, 1, 0, -1 };
        int ans = 1;
        for (int l = 0; l < 4; l++) {
            int ci = i + di[l], cj = j + dj[l];
            if (ci >= 0 && ci < m && cj >= 0 && cj < n && grid[i][j] < grid[ci][cj]) {
                ans = (int) ((ans + dfs(grid, ci, cj, m, n, dp, mod)) % mod);
            }
        }
        dp[i][j] = ans;
        return dp[i][j];
    }

    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] dp = new long[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        long mod = 1000000007L;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = (int)((res + dfs(grid, i, j, m, n, dp, mod)) % mod);
            }
        }

        return res;
    }
}