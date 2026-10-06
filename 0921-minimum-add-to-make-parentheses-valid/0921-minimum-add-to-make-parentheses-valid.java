class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int cnt = 0;

        for(char ch : s.toCharArray()){
            if(ch == '(')
                st.push('(');
            else{
                if(!st.isEmpty())
                    st.pop();
                else
                    cnt++;
            }
        }
        return cnt + st.size();
    }
}