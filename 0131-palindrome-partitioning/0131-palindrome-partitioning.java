class Solution {
    boolean isPalindrome(String str, int i, int j){
        while(i <= j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    void recursion(List<List<String>> res, List<String> ans, String s, int index, int n){
        if(index == n){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i = index ; i < n; i++){
            if(isPalindrome(s, index, i )){
                ans.add(s.substring(index, i + 1));
                recursion(res, ans, s, i + 1, n);
                ans.remove(ans.size()- 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        recursion(res, ans, s, 0, s.length());
        return res;
    }
}