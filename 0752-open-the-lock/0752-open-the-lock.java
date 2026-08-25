class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> st = new HashSet<>();
        Set<String> vis = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
    
        q.add(new Pair("0000",0));
        vis.add("0000");
        for(int i = 0; i < deadends.length; i++)
            st.add(deadends[i]);
        
        if(st.contains("0000"))
            return -1;

        while(!q.isEmpty()){
            String str = q.peek().first;
            int step = q.peek().second;
            q.remove();

            if(str.equals(target)) return step;

            for(int i = 0; i < 4; i++){
                char[] ans = str.toCharArray();
                if(ans[i] == '0'){
                    ans[i] = '9';
                    String res = new String(ans);
                    if(!st.contains(res) && !vis.contains(res)){
                        vis.add(res);
                        q.add(new Pair(res, step + 1));
                    }
                    ans[i] = '1';
                    res = new String(ans);
                    if(!st.contains(res) && !vis.contains(res)){
                        vis.add(res);
                        q.add(new Pair(res, step + 1));
                    }
                }
                else if(ans[i] == '9'){
                    ans[i] = '0';
                    String res = new String(ans);
                    if(!st.contains(res) && !vis.contains(res)){
                        vis.add(res);
                        q.add(new Pair(res, step + 1));
                    }
                    ans[i] = '8';
                     res = new String(ans);
                    if(!st.contains(res) && !vis.contains(res)){
                        vis.add(res);
                        q.add(new Pair(res, step + 1));
                    }
                }
                else{
                    ans[i] = (char)(ans[i] + 1);
                    String res = new String(ans);
                    if(!st.contains(res) && !vis.contains(res)){
                        vis.add(res);
                        q.add(new Pair(res, step + 1));
                    }
                    ans[i] = (char)(ans[i] - 2);
                     res = new String(ans);
                    if(!st.contains(res) && !vis.contains(res)){
                        vis.add(res);
                        q.add(new Pair(res, step + 1));
                    }
                }
            }
        }
        return -1;
    }
}