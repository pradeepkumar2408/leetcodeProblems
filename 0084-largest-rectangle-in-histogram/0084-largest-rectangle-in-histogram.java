class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> st = new Stack<>();
        int res = 0;
        for(int i = 0; i < heights.length; i++){
                int start = i;
                while(!st.isEmpty() && st.peek().first > heights[i]){
                    int val = st.peek().first, width = st.peek().second;
                    st.pop();
                    res = Math.max(res, val * (i - width ));
                    start = width;
                }
                st.push(new Pair(heights[i], start));
        }
        int width = heights.length - 1;
        while(!st.isEmpty()){
            res = Math.max(res, (st.peek().first) * (width - st.peek().second + 1));
            st.pop();
        }
        return res;
    }
}