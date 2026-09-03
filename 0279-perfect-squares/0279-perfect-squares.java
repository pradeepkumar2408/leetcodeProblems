class Solution {
    public int numSquares(int n) {
        if(n == 1)
            return 1;
        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i < n; i++){
            if(i * i > n)
                break;
            nums.add(i * i);
        }
        int m = nums.size();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= n; i++){
            dp[0][i] = Integer.MAX_VALUE - 1;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n ; j++){
                if(j - nums.get(i - 1) >= 0){
                    dp[i][j] = Math.min(dp[i][j - nums.get(i - 1)] + 1, dp[i - 1][j]);
                }else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
}