class Solution {
    public int maxLength(List<String> arr) {
        int n = 1 << arr.size(), res = 0;
        for(int i = 0; i < n; i++){
            StringBuilder ans = new StringBuilder();
            Set<Character> st = new HashSet<>();
            for(int k = 0; k < arr.size(); k++){
                if((i & (1 << k)) != 0){
                    ans.append(arr.get(k));
                }
            }
            char[] ans1 = ans.toString().toCharArray();
            for(char ch : ans1){
                st.add(ch);
            }
            if(ans1.length == st.size()){
                res = Math.max(res, st.size());
            }
        }
        return res;
    }
}