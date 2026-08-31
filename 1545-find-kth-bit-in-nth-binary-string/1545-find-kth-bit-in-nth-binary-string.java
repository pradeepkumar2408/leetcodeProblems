class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder res = new StringBuilder("0");
        while(n != 0){
            StringBuilder temp = new StringBuilder();
            for(int i = res.length() - 1; i >= 0 ; i--){
                if(res.charAt(i) == '0')
                    temp.append('1');
                else
                    temp.append('0');
            }
            res.append('1');
            res.append(temp);
            n--;
        }
        return res.charAt(k - 1);
    }
}