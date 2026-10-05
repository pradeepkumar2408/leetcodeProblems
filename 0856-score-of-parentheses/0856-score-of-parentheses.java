class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(char ch :  s.toCharArray()){
            int score = 0;
            if(ch == ')'){
                int val = st.pop();
                if(val == 0)
                    score = 1;
                else
                    score = 2 * val;
                st.push(st.pop() + score);
            }
            else{
                st.push(0);
            }
        }
        return st.peek();
    }
}