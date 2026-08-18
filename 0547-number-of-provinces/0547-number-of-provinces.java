class Solution {
    void dfs(boolean[] vis, int[][] isConnected, int i, int n){
        vis[i] = true;

        for(int j = 0; j < n; j++){
            if(!vis[j] && isConnected[i][j] == 1){
                dfs(vis, isConnected, j, n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n ; i++){
            if(!vis[i]){
                dfs(vis, isConnected, i , n);
                count++;
            }
        }
        return count;
    }
}