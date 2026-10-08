class Solution {
    int dpCalculate(int i, int j, int[][] grid, int m, int n, int[][] dp){
        if(i >= m || j >= n || i < 0 || j < 0)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int ans = 0;
        int[] di = {-1, 0, 1}, dj = {1, 1, 1};
        for(int l = 0; l < 3; l++){
            int ci = i + di[l], cj = j + dj[l];
            if(ci >= 0 && ci < m && cj >= 0 && cj < n && grid[ci][cj] > grid[i][j])
                ans = Math.max(ans , 1 + dpCalculate(ci, cj, grid, m, n, dp));
        }
        return dp[i][j] = ans;
    }
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        for(int j = 0; j < m; j++){
             res = Math.max(res, dpCalculate(j, 0, grid, m, n, dp));
        }
        return  res;
    }
}