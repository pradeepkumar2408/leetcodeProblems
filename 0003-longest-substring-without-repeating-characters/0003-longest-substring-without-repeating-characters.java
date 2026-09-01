class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        int res = 0, left = 0;
        for(int i = 0; i < s.length(); i++){
            if(mp.containsKey(s.charAt(i))){
                left = Math.max(left,mp.get(s.charAt(i)) + 1);
            }
                mp.put(s.charAt(i), i);
                res  = Math.max(res, i - left + 1);
        }
        return res;
    }
}