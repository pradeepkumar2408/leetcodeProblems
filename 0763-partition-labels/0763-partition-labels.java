class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            mp.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int left = 0, range = mp.get(s.charAt(0));
        for(int right = 0; right < s.length(); right++){
            range = Math.max(range, mp.get(s.charAt(right)));
            if(range == right){
                res.add(right - left + 1);
                left = right + 1;
            }
            
        }
        return res;
    }
}