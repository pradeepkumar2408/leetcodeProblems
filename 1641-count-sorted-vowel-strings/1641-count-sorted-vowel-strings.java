class Solution {
    int dpCalculate(int i, String[] letters, int n){
        if(0 == n)
            return 1;
        int ans = 0;
        for(int j = i; j < letters.length; j++){
            ans += dpCalculate(j, letters, n-1);
        }
        return ans;
    }
    public int countVowelStrings(int n) {
        String[] letters = {"a", "e", "i","o", "u"};
        return dpCalculate(0, letters, n);
    }
}