class Solution {
    int mod = (int)1e9+7;
    int dpCalculate(int m, int n, int[][] grid, int[][][] dp, int k, int sum){
        if(m < 0 || n < 0)
            return 0;
        if(m == 0 && n == 0){
            if((grid[m][n] + sum) % k == 0)
                return 1;
        }
        if(dp[m][n][sum % k] != -1)
            return dp[m][n][sum % k];
        int ans = 0;
        ans = (ans + dpCalculate(m - 1, n, grid, dp, k, sum + grid[m][n])) % mod;
        ans = (ans +dpCalculate(m, n - 1, grid, dp, k, sum + grid[m][n])) % mod;
        return dp[m][n][sum % k] = ans;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][50];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
            Arrays.fill(dp[i][j], -1);
        return dpCalculate(m-1,n-1,grid,dp,k,0);
    }
}