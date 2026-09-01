class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : magazine.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for(char ch : ransomNote.toCharArray()){
            if(mp.getOrDefault(ch,0) == 0){
                return false;
            }else{
                mp.put(ch, mp.get(ch) - 1);
            }
        }
        return true;
    }
}