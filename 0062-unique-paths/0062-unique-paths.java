class Solution {
    int dpCalculate(int i, int j , int m, int n, int[][] dp){
        if(i >= m || j >= n)
            return 0;
        if(m-1 == i && n-1 == j)
            return 1;
        if(dp[i][j] != -1)
            return dp[i][j];
        int cnt = 0;
        cnt += dpCalculate(i+1, j, m, n, dp);
        cnt += dpCalculate(i, j+1, m, n, dp);
        return dp[i][j] = cnt;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
        Arrays.fill(dp[i], -1);
        return dpCalculate(0,0,m,n,dp);
    }
}