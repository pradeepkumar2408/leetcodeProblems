class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        for(int i = 1; i < 31 && (1<<i)<=n; i++){
            int curr = (n & (1 << i)) != 0 ? 1 : 0;
                if(curr == prev)
                    return false;
            prev= curr; 
        }
        return true;
    }
}