class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> st = new HashSet<>();
        for(int i = 0; i < digits.length; i++){
            for(int j = 0; j < digits.length; j++){
                for(int k = 0; k < digits.length; k++){
                    if(i != j && j != k && i != k){
                        int val = (digits[i] * 100) + (digits[j] * 10) + digits[k];
                        if(val % 2 == 0 && val >= 100)
                            st.add(val);
                    }
                }
            }
        }
        return st.size();
    }
}