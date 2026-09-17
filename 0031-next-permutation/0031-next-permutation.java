class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        for(i = nums.length - 1; i >= 1; i--){
            if(nums[i - 1] < nums[i])
                break;
        }

        if(i == 0){
        int j = nums.length - 1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
            return;
        }
        for(int j = nums.length - 1; j >= i; j--){
            if(nums[j] > nums[i - 1]){
                nums[j] = nums[j] ^ nums[i - 1];
                nums[i - 1] = nums[j] ^ nums[i - 1];
                nums[j] = nums[j] ^ nums[i - 1];
                break;
            }
        }
        int j = nums.length - 1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}