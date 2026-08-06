class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int temp = n,val = 1;
            while(temp != 0){
                int d = temp % 10;
                val *= d;
                temp /= 10;
            }
            if(val % t == 0)
                return n;
            n++;
        }
    }
}