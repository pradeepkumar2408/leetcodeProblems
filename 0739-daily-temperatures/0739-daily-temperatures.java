class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        st.push(0);
        for(int i = 1 ; i < temperatures.length ; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}