class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(target >= letters[mid]){
                low = mid + 1;
            }else
                high = mid - 1;
        }
        if(low >= letters.length)
            return letters[0];
        return letters[low];
    }
}