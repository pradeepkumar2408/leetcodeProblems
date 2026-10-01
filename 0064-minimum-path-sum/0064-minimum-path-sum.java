class Solution {
    int dpCalculate(int m, int n,int[][] grid, int[][] dp){
        if(m < 0 || n < 0)
            return (int)1e7;
        if(m == 0 && n == 0)
            return grid[0][0];
        if(dp[m][n] != -1)
            return dp[m][n];
        int ans = (int)1e7;
        ans = Math.min(ans, grid[m][n] + dpCalculate(m - 1, n, grid, dp));
        ans = Math.min(ans, grid[m][n] + dpCalculate(m, n - 1, grid, dp));
        return dp[m][n] = ans;
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        return dpCalculate(m - 1, n - 1, grid, dp);
    }
}