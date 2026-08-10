class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isEnd;
}

class Solution {
    TrieNode root = new TrieNode();
    void insert(String word){
        TrieNode current = root;

        for(char ch : word.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null)
                current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.isEnd = true;
    }
    public String longestCommonPrefix(String[] strs) {
        for(String s : strs){
            insert(s);
        }

        TrieNode current = root;
        StringBuilder res = new StringBuilder();
        while(true){
            int count = 0, next = -1;
            for(int i = 0; i < 26; i++){
                if(current.children[i] != null){
                    count++;
                    next = i;
                }
            }
                if(count != 1){
                    break;
                }
                if(current.isEnd){
                    break;
                }
            res.append((char)('a' + next));
            current = current.children[next];
        }
        return res.toString();
    }
}