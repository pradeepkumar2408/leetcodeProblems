class Solution {
    int dpCalculate(int i, int balance, String s, int[][] dp){
        if(i == s.length() && balance == 0)
            return 1;
        if(i == s.length() || balance < 0)
            return 0;
        if(dp[i][balance] != -1)
            return dp[i][balance];
        int ans = 0;
        if(s.charAt(i) == '('){
           ans = dpCalculate(i + 1, balance + 1, s, dp);
        }else if(s.charAt(i) == ')'){
           ans = dpCalculate(i + 1, balance - 1, s, dp);
        }else{
           boolean res = dpCalculate(i + 1, balance, s, dp) == 1 ||
            dpCalculate(i + 1, balance + 1, s, dp) == 1||
            dpCalculate(i + 1, balance - 1, s, dp) == 1;
            if(res)
                ans = 1;
            else
                ans = 0;
        }
        return dp[i][balance] = ans;
    }
    public boolean checkValidString(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++)
            Arrays.fill(dp[i], -1);
        return dpCalculate(0, 0, s, dp) == 1 ? true : false;
    }
}