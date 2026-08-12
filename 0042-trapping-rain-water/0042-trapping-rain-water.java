class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, lMax = height[left], rMax = height[right], res = 0;

        while(left < right){
            if(lMax < rMax){
                left++;
                lMax = Math.max(lMax, height[left]);
                res += lMax - height[left];
            }
            else{
                right--;
                rMax = Math.max(rMax, height[right]);
                res += rMax - height[right];
            }
        }        
        return res;
    }
}