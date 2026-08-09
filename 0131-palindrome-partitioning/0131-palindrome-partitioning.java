class Solution {
    boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
    void find(int index, String s, List<List<String>> res, List<String> ans, int n){
        if(index == n){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int i = index; i < n ; i++){
            if(isPalindrome(s, index, i)){
                ans.add(s.substring(index, i + 1));
                find(i + 1, s, res, ans, n);
                ans.remove(ans.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        find(0, s, res, ans, s.length());
        return res;
    }
}