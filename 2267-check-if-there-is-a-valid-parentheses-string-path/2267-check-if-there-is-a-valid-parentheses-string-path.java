class Solution {
    boolean dpCalculate(int i, int j, char[][] grid, int m, int n, int open, int[][][] dp){
         if(open < 0)
            return false;
        if(i == m - 1 && j == n - 1){
                if(grid[i][j] == '(') open++;
                else
                    open--;
                if(open == 0)
                return true;
            return false;
        }
        if(i >= m ||  j >= n)
            return false;
       
        if(dp[i][j][open] != -1)
            return dp[i][j][open] == 1? true : false;
        boolean ans = false;
        if(grid[i][j] == '('){
            ans = ans || dpCalculate(i + 1, j, grid, m, n, open + 1, dp);
            ans = ans || dpCalculate(i, j + 1, grid, m, n, open + 1, dp);
        }else{
            ans = ans || dpCalculate(i + 1, j, grid, m, n, open - 1, dp);
            ans = ans || dpCalculate(i, j + 1, grid, m, n, open - 1, dp);
        }
        if(ans)
            dp[i][j][open] = 1;
        else
            dp[i][j][open] = 0;
        return ans;
    }
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][m + n];

        for(int[][] i : dp){
            for(int[] j : i){
                Arrays.fill(j, -1);
            }
        }
        
        return dpCalculate(0, 0, grid, m, n, 0, dp);
    }
}