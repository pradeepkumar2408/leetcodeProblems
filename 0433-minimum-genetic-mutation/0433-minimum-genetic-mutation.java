class Pair{
    String first;
    int second;

    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> st = new HashSet<>();
        for(int i = 0; i < bank.length; i++)
            st.add(bank[i]);
        
        q.add(new Pair(startGene, 0));
        String find = "ACGT";
        while(!q.isEmpty()){
            String str = q.peek().first;
            int step = q.peek().second;
            q.remove();
            if(str.equals(endGene))
                return step;
            for(int i = 0; i < str.length(); i++){
                char[] ans = str.toCharArray();
                for(int j = 0; j < find.length(); j++){
                    ans[i] = find.charAt(j);
                    String res = new String(ans);
                    if(st.contains(res)){
                        st.remove(res);
                        q.add(new Pair(res, step + 1));
                    }
                }
            }
        }
        return -1;
    }
}