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
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dis = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){
                    vis[i][j] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};
        while(!q.isEmpty()){
            int i = q.peek().first, j = q.peek().second, step = q.peek().third;
            q.remove();
            dis[i][j] = step;
            for(int l = 0; l < 4; l++){
                int ci = i +  di[l], cj = j + dj[l];
                if(ci >= 0 && ci < n && cj >= 0 && cj < n && !vis[ci][cj] && grid.get(ci).get(cj) == 0){
                    vis[ci][cj] = true;
                    q.add(new Pair(ci, cj , step + 1));
                }
            }
        }
        for(int i = 0; i < n; i++)
            Arrays.fill(vis[i], false);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(y.third, x.third));
        pq.add(new Pair(0,0,dis[0][0]));
        vis[0][0] = true;
        int res = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int i = pq.peek().first, j = pq.peek().second, step = pq.peek().third;
            pq.remove();
            res = Math.min(res, step);
            if(i == n - 1 && j == n - 1)
                return res;
            for(int l = 0; l < 4; l++){
                int ci = i + di[l], cj = j + dj[l];
                if(ci >= 0 && ci < n && cj >= 0 && cj < n && !vis[ci][cj] && grid.get(ci).get(cj) != 1){
                    vis[ci][cj] = true;
                    pq.add(new Pair(ci, cj, dis[ci][cj]));
                }
            }
        }

        return 0;
    }
}