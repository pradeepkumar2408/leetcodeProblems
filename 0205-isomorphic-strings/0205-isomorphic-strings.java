class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mp1 = new HashMap<>();
        Map<Character, Character> mp2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i), b = t.charAt(i);

            if(mp1.containsKey(a) && mp1.get(a) != b){
                return false;
            }
            if(mp2.containsKey(b) && mp2.get(b) != a){
                return false;
            }

            mp1.put(a, b);
            mp2.put(b, a);
        }
        return true;
    }
}