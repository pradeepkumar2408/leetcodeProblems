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
    void dfs(int[][] grid, int[][] vis, int i, int j, int n, int c, int[] di, int[] dj){
        vis[i][j] = c;
        for(int l = 0; l < 4; l++){
            int ci = i + di[l], cj = j + dj[l];
            if(ci >= 0 && ci < n && cj >= 0 && cj < n && vis[ci][cj] == 0 && grid[ci][cj] == 1){
                dfs(grid, vis, ci, cj, n, c, di, dj);
            }
        }

    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] vis = new int[n][n];
        int c = 1;
        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    dfs(grid, vis, i, j, n, c, di, dj);
                    c++;
                }
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(x.third, y.third));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 1){
                    pq.add(new Pair(i, j, 0));
                }
            }
        }

        while(!pq.isEmpty()){
            int i = pq.peek().first, j = pq.peek().second, step = pq.peek().third;
            pq.remove();
            
             for(int l = 0; l < 4; l++){
                int ci = i + di[l], cj = j + dj[l];
                if(ci >= 0 && ci < n && cj >= 0 && cj < n && vis[ci][cj] != 1){
                    if(vis[ci][cj] == 2)
                        return step;
                    vis[ci][cj] = 1;
                    pq.add(new Pair(ci, cj, step + 1));
                }
             }
        }
        return 0;
    }
}