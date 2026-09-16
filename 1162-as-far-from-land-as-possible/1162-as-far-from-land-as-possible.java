class Pair{
    int first;
    int second;
    int third;
    Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    vis[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};

        int res = -1;
        while(!q.isEmpty()){
            int i = q.peek().first, j = q.peek().second, step = q.peek().third;
            q.remove();
            res = Math.max(res, step);
            for(int l = 0; l < 4; l++){
                int ci = i + di[l], cj = j + dj[l];
                if(ci >= 0 && ci < n && cj >= 0 && cj < n && !vis[ci][cj] && grid[ci][cj] == 0){
                    vis[ci][cj] = true;
                    q.add(new Pair(ci, cj, step + 1));
                }
            }
        }

        return res == 0 ? -1: res;
    }
}