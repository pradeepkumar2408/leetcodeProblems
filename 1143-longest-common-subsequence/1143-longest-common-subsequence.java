class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] arr = new int[n+1][m+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(text1.charAt(i) == text2.charAt(j))
                    arr[i+1][j+1] = arr[i][j] + 1;
                else
                    arr[i+1][j+1] = Math.max(arr[i][j+1], arr[i+1][j]);
            }
        }
        return arr[n][m];
    }
}