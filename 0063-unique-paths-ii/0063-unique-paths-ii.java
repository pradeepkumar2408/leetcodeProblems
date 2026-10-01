class Solution {
    int dpCalculate(int m, int n, int[][] dp, int[][] obstacleGrid){
        if(m < 0 || n < 0 || obstacleGrid[m][n] == 1)
            return 0;
        if(m == 0 && n == 0)
            return 1;
        if(dp[m][n] != -1)
            return dp[m][n];
        int cnt = 0;
        cnt += dpCalculate(m - 1, n, dp, obstacleGrid);
        cnt += dpCalculate(m, n - 1, dp, obstacleGrid);
        return dp[m][n] = cnt;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        return dpCalculate(m - 1, n - 1, dp, obstacleGrid);
    }
}