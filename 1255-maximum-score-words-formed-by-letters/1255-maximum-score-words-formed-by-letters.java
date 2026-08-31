class Solution {
    int check(Map<Character, Integer> mp, String str, int[] score){
        Map<Character, Integer> mp1 = new HashMap<>();
        int res = 0;
        char[] ans = str.toCharArray();
        for(char ch : ans){
            mp1.put(ch, mp1.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < str.length(); i++){
            if(mp1.get(str.charAt(i)) <= mp.getOrDefault(str.charAt(i),0))
                res += score[str.charAt(i) - 'a'];
            else
                return 0;
        }
        return res;
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = 1 << words.length, res = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : letters){
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i < n ; i++){
            StringBuilder str = new StringBuilder();
            for(int k = 0; k < words.length; k++){
                if((i & (1 << k)) != 0){
                    str.append(words[k]);
                }
            }
            String s = str.toString();
            res = Math.max(res, check(mp, s, score));
        }
        return res;
    }
}