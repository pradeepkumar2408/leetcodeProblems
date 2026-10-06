class Pair {
    String first;
    int second;

    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int cnt = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(')
                st.push('(');
            else if(ch == ')'){
                if (!st.isEmpty())
                    st.pop();
                else
                    cnt++;
            }
        }
        return cnt + st.size();
    }

    boolean isValid(String s) {
        int open = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                open++;
            else if (ch == ')')
                open--;
            if(open < 0)
                return false;
        }
        return open == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        int minCost = minAddToMakeValid(s);
        List<String> res = new ArrayList<>();
        Set<String> st = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(s, 0));
        st.add(s);

        while (!q.isEmpty()) {
            String test = q.peek().first;
            int step = q.peek().second;
            q.remove();

            if (step == minCost) {
                //System.out.println(test);
                if (isValid(test))
                    res.add(test);
                    continue;
            }

            for (int i = 0; i < test.length(); i++) {
                if(Character.isAlphabetic(test.charAt(i)))
                    continue;
                StringBuilder ans = new StringBuilder(test);
                ans.deleteCharAt(i);
                ///System.out.println(ans.toString());
                if (!st.contains(ans.toString())){
                    st.add(ans.toString());
                    q.add(new Pair(ans.toString(), step + 1));
                }
            }
        }
        return res;
    }
}