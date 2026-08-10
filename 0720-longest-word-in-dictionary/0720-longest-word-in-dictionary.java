class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

class Solution {
    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null)
                current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.isEnd = true;
    }

    int search(String word) {
        TrieNode current = root;
        int count = 0;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null)
                return count;
            current = current.children[index];
            if (!current.isEnd)
                return count;
            count++;

        }
        return count;
    }

    public String longestWord(String[] words) {
        for (String s : words) {
            insert(s);
        }

        String res = "";
        for (String s : words) {
            int val = search(s);
            if (val == s.length()) {
                if (res.length() < s.length()) {
                    res = s;
                } else if (res.length() == s.length()) {
                    if (res.compareTo(s) > 0) {
                        res = s;
                    }
                }
            }
        }
        return res;
    }
}