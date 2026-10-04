class Solution {
    int res = 0;
    int dpCalculate(int i, int j, char[][] matrix, int m, int n,int[][] dp){
        if(i >= m || j >= n)
            return 0;
        if(matrix[i][j] == '0')
            return 0;
        if(dp[i][j] != - 1)
            return dp[i][j];
        int right = 0, down = 0, diagonal = 0;
        right = dpCalculate(i, j + 1, matrix,m, n, dp);
        down =  dpCalculate(i + 1, j, matrix, m, n, dp);
        diagonal = dpCalculate(i + 1, j + 1, matrix, m, n, dp);
        int ans = Math.min(right, Math.min(down, diagonal)) + 1;
        res = Math.max(ans, res);
        return dp[i][j] = ans;
    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dpCalculate(i, j, matrix, m, n, dp);
            }
        }
        return res * res;
    }
}