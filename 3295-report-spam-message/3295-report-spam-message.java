class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Map<String, Integer> mp = new HashMap<>();
        for(String s : bannedWords){
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }

        int cnt = 0;
        for(int i = 0; i < message.length; i++){
            if(mp.containsKey(message[i]))
                cnt++;
        }
        return cnt > 1;
    }
}