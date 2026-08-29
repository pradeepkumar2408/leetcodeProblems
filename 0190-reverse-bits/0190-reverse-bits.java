class Solution {
    public int reverseBits(int n) {
        int res = 0, bit = 31;
        for(int i = 0; i < 32; i++){
            if((n &(1 << i)) != 0){
                res = res | (1 << bit);
            }
            bit--;
        }
        return res;
    }
}