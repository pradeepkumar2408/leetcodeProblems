class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int b = st.pop();
                int a = st.pop();
                if(s.equals("+"))
                    st.push(a + b);
                if(s.equals("-"))
                    st.push(a - b);
                if(s.equals("*"))
                    st.push(a * b);
                if(s.equals("/"))
                    st.push(a / b);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}