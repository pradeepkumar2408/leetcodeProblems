class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            int one = 0, zero = 0;
            if((a & (1 << i)) != 0 )
                one++;
            else 
                zero++;
            
            if((b & (1 << i)) != 0)
                one++;
            else
                zero++;

            if((c & (1 << i)) != 0 && one == 0){
                 res++;
            }else if((c & (1 << i)) == 0){
                res += one;
            }
        }
        return res;
    }
}