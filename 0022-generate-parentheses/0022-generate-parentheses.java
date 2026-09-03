class Solution {
    void recursion(List<String> res, int open, int close, StringBuilder ans){
        if(open == 0 && close == 0){
            res.add(ans.toString());
            return;
        }
        if(open > 0){
            ans.append('(');
            recursion(res, open - 1, close + 1, ans);
            ans.deleteCharAt(ans.length() - 1);
        }
        if(close > 0){
            ans.append(')');
            recursion(res, open, close - 1, ans);
            ans.deleteCharAt(ans.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        recursion(res, n, 0, ans);
        return res;
    }
}