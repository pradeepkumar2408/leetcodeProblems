class Solution {
    int mod = (int)1e9+7;
    int dpCalculate(int i, int j, int MaxMove, int m, int n, int[][][] dp){
        if(MaxMove < 0)
            return 0;
        if(i >= m || j >= n || i < 0 || j < 0){
            if(MaxMove >= 0)
                return 1;
            return 0;
        }
        if(dp[i][j][MaxMove] != -1)
            return dp[i][j][MaxMove];
        int ans = 0;
        int[] di = {-1, 0, 1, 0}, dj = {0, 1, 0, -1};
        for(int l = 0; l < 4; l++){
            int ci = i + di[l], cj = j + dj[l];
            ans =(ans + dpCalculate(ci, cj, MaxMove - 1, m, n, dp)) % mod;
        }
        return dp[i][j][MaxMove] = ans;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                Arrays.fill(dp[i][j], -1);
        return dpCalculate(startRow, startColumn, maxMove, m, n, dp);
    }
}