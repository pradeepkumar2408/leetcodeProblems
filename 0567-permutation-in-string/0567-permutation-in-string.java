class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
            return false;

        Map<Character, Integer> mp1 = new HashMap<>();

        for(char ch : s1.toCharArray())
            mp1.put(ch, mp1.getOrDefault(ch, 0) + 1);

        Map<Character, Integer> mp2 = new HashMap<>();

        int k = s1.length();

        for(int i = 0; i < k; i++) {
            mp2.put(s2.charAt(i),
                    mp2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int left = 0;

        for(int i = k; i < s2.length(); i++) {
            if(mp1.size() == mp2.size()) {

                int cnt = 0;

                for(Map.Entry<Character, Integer> entry : mp1.entrySet()) {

                    if(mp2.containsKey(entry.getKey()) &&
                       entry.getValue().equals(mp2.get(entry.getKey()))) {
                        cnt++;
                    }
                }

                if(cnt == mp1.size())
                    return true;
            }

            char remove = s2.charAt(left);

            if(mp2.get(remove) == 1)
                mp2.remove(remove);
            else
                mp2.put(remove, mp2.get(remove) - 1);

            char add = s2.charAt(i);

            mp2.put(add, mp2.getOrDefault(add, 0) + 1);

            left++;
        }
        if(mp1.size() == mp2.size()) {

            int cnt = 0;

            for(Map.Entry<Character, Integer> entry : mp1.entrySet()) {

                if(mp2.containsKey(entry.getKey()) &&
                   entry.getValue().equals(mp2.get(entry.getKey()))) {
                    cnt++;
                }
            }

            if(cnt == mp1.size())
                return true;
        }

        return false;
    }
}