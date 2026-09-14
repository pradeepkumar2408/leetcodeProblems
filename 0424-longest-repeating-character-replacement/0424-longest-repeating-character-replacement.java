class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int left = 0, res = 0, maxFreq = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, mp.get(ch));
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                mp.put(leftChar, mp.get(leftChar) - 1);
                left++;
            }
                res = Math.max(res, right - left + 1);
        }
        return res;
    }
}