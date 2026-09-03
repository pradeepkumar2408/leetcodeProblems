class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), res = 0;
        int[] dp = new int[n];
        Stack<Character> st = new Stack();
       
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == ')'){
                if(!st.isEmpty()){
                    st.pop();
                    dp[i] = dp[i - 1] + 2;
                    if(i - dp[i] >= 0)
                        dp[i] += dp[i - dp[i]];
                }
            }else{
                st.push('(');
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}