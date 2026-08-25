class Pair{
    String first;
    int second;

    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++){
            st.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            String str = q.peek().first;
            int step = q.peek().second;
            q.remove();
            
            if(str.equals(endWord)) return step;

            for(int i = 0; i < str.length(); i++){
                char[] ans = str.toCharArray();
                for(char ch = 'a' ; ch <= 'z'; ch++){
                    ans[i] = ch;
                    String res = new String(ans);
                    if(st.contains(res)){
                        st.remove(res);
                        q.add(new Pair(res, step + 1));
                    }

                }
            }
        }
        return 0;
    }
}