class Solution {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();

        int n = 0;
        str.push(new StringBuilder(""));
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                n = n * 10 + s.charAt(i) - '0';
            }else if(s.charAt(i) == '['){
                num.push(n);
                str.push(new StringBuilder(""));
                n = 0;
            }else if(Character.isLetter(s.charAt(i))){
                StringBuilder ans = str.peek();
                str.pop();
                ans.append(s.charAt(i));
                str.push(ans);
            }else if(s.charAt(i) == ']'){
                int val = num.peek();
                num.pop();
                StringBuilder ans = str.peek();
                str.pop();
                StringBuilder res = new StringBuilder();
                for(int j = 0; j < val; j++)
                    res.append(ans);
                StringBuilder s1 = str.peek();
                str.pop();
                s1.append(res);
                str.push(s1);
            }
        }
        return str.peek().toString();
    }
}