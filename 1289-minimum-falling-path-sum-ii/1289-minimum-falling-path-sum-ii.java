class Solution {
    int dpCalculate(int i, int j, int[][] matrix, int[][] dp){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix.length)
            return (int)1e9;
        if(i == matrix.length - 1)
            return matrix[i][j];
        if(dp[i][j] != (int)-1e9)
            return dp[i][j];
        int ans = (int)1e9;
        for(int k = 0; k < matrix.length; k++){
            if(j == k) continue;
            ans = (int)(Math.min(ans, matrix[i][j] + dpCalculate(i + 1, k, matrix, dp)));
        }
        return dp[i][j] = ans ;
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length, res = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], (int)-1e9);
        for(int i = 0; i < n; i++){
            res = Math.min(res, dpCalculate(0, i, matrix, dp));
        }
        return res;
    }
}