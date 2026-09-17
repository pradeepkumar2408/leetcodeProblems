class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, 0));
        Set<Integer> st = new HashSet<>();
        st.add(x);
        while(!q.isEmpty()){
            int val = q.peek().first, step = q.peek().second;
            q.remove();
            if(val == y)
                return step;
            if(val % 11 == 0 && !st.contains(val/11)){
                q.add(new Pair(val/11, step + 1));
                st.add(val/11);
            }if(val % 5 == 0 && !st.contains(val/5)){
                q.add(new Pair(val/5, step + 1));
                st.add(val / 5);
            }
            if(!st.contains(val + 1)){
            q.add(new Pair(val + 1, step + 1));
            st.add(val + 1);
            }
            if( val - 1 > 0 && !st.contains(val - 1)){
                q.add(new Pair(val - 1, step + 1));
                st.add(val - 1);
            }
        }
        return 0;
    }
}