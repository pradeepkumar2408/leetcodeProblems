class Solution {
    int dfs(int[][] matrix, int[][] dp, int i, int j, int m, int n){
        if(dp[i][j] != -1)
            return dp[i][j];
        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};
        int ans = 1;
        for(int l = 0; l < 4; l++){
            int ci = i + di[l] , cj = j + dj[l];
            if(ci >= 0 && ci < m && cj >= 0 && cj < n && matrix[i][j] < matrix[ci][cj]){
                ans = Math.max(ans,dfs(matrix, dp, ci, cj , m, n) + 1);
            }
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dfs(matrix, dp, i , j, m, n));
            }
        }
        return res;
    }
}