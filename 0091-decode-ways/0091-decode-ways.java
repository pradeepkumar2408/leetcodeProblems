class Solution {
    int dpCalculate(int i, String s, int[] dp){
        if(i >= s.length())
            return 1;
        if(dp[i] != -1)
            return dp[i];
        int cnt = 0;
        if(Character.getNumericValue(s.charAt(i)) != 0)
        cnt = cnt + dpCalculate(i + 1, s, dp);
        if(i + 1 < s.length() && Character.getNumericValue(s.charAt(i)) != 0 && Integer.parseInt(s.substring(i, i + 2)) <= 26 )
        cnt = cnt + dpCalculate(i + 2, s, dp);
        return dp[i] = cnt;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dpCalculate(0, s, dp);
    }
}