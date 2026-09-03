class Solution {
    void recursion(List<String> res, Map<Character, String> mp, String digits, StringBuilder ans, int index){
        if(ans.length() == digits.length()){
            String s = ans.toString();
            res.add(s);
            return;
        }
        String str = mp.get(digits.charAt(index));
        for(int i = 0; i < str.length(); i++){
            ans.append(str.charAt(i));
            recursion(res, mp, digits, ans, index + 1);
            ans.deleteCharAt(ans.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character, String> mp = new HashMap<>();
        mp.put('2', "abc"); mp.put('3',"def"); mp.put('4', "ghi"); mp.put('5', "jkl"); mp.put('6', "mno"); mp.put('7', "pqrs"); mp.put('8', "tuv"); mp.put('9', "wxyz");
        
        List<String> res = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        recursion(res, mp, digits, ans, 0);
        return res;
    }
}