class Solution {
    public int integerReplacement(int num) {
        long n = num;
        int cnt = 0;
        while(n != 1){
            if((n & 1) == 0){
                n = n >> 1;
            }else{
                if( n == 3 || (n & 2) == 0){
                    n = n - 1;
                }else 
                    n = n + 1;
            }
            cnt++;
        }
        return cnt;
    }
}