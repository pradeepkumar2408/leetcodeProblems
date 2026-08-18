class Solution {
    int dfs(boolean[][] vis, int[][] grid, int i, int j, int m, int n) {
        vis[i][j] = true;
        int ans = 1;
        int[] di = { 1, 0, -1, 0 };
        int[] dj = { 0, 1, 0, -1 };

        for (int l = 0; l < 4; l++) {
            int ci = i + di[l], cj = j + dj[l];

            if (ci >= 0 && ci < m && cj >= 0 && cj < n && !vis[ci][cj] && grid[ci][cj] == 1) {
                ans += dfs(vis, grid, ci, cj, m, n);
            }
        }
        return ans;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    int val = dfs(vis, grid, i, j, m, n);
                    max = Math.max(max, val);
                }
            }
        }
        return max;
    }
}