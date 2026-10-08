class Solution {
public:
    string removeOuterParentheses(string s) {
        string res = "";
        int depth = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                if (depth > 0)
                    res += s[i];
                depth++;
            }

            else {
                depth--;
                if (depth > 0)
                    res += s[i];
            }
        }
        return res;
    }
};