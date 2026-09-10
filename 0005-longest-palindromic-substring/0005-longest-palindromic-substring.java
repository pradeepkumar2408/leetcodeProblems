class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), max = 0;
        String ans = "";
        int[][] dp = new int[n][n];
        for (int diff = 0; diff < n; diff++) {
            for (int i = 0, j = i + diff; j < n; j++, i++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (diff == 1) {
                    if (s.charAt(i) == s.charAt(j))
                        dp[i][j] = 2;
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                    ans = s.substring(i,i+max);
                }
            }
        }
        return ans;
    }
}