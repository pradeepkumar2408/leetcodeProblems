class Solution {
    int find(String s, boolean flag){
        int cnt = 0;
        for(char ch : s.toCharArray()){
            if(flag){
                if(ch == '0')
                    cnt++;
            }else{
                if(ch == '1')
                    cnt++;
            }
        }
        return cnt;
    }
    int dpCalculate(int i, String[] strs, int m, int n, int[][][] dp){
        if(i >= strs.length)
            return 0;
        if(dp[i][m][n] != -1)
            return dp[i][m][n];

        int ans = 0;
        ans = Math.max(ans , dpCalculate(i + 1, strs, m, n, dp)); 
        int zero = find(strs[i],true), one = find(strs[i], false); 
        if(zero <= m && one <= n)
            ans = Math.max(ans , 1 + dpCalculate(i + 1, strs, m - zero, n - one, dp));
        return dp[i][m][n] = ans;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for(int i = 0; i < strs.length; i++)
            for(int j = 0; j <= m; j++)
                Arrays.fill(dp[i][j], -1);
        return dpCalculate(0, strs, m, n, dp);
    }
}