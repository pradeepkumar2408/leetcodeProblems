class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    Pair bfs(int[][] land, boolean[][] vis, int i, int j, int m, int n){
        vis[i][j] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        int[] di = {-1 , 0 , 1 , 0};
        int[] dj = {0, 1, 0, -1};
        Pair val = new Pair(i,j);
        while(!q.isEmpty()){
            i = q.peek().first; j = q.peek().second;
            q.remove();
            for(int l = 0; l < 4; l++){
                int ci = i + di[l], cj = j + dj[l];
                if(ci >= 0 && ci < m && cj >= 0 && cj < n && !vis[ci][cj] && land[ci][cj] == 1){
                    q.add(new Pair(ci, cj));
                    val.first = ci;
                    val.second = cj;
                    vis[ci][cj] = true;
                }
            }
        }
        return val;
    }
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        boolean[][] vis = new boolean[m][n];
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1 && !vis[i][j]){
                   ArrayList<Integer> ans = new ArrayList<>();
                   ans.add(i);
                   ans.add(j);
                   Pair val = bfs(land, vis, i, j, m, n);
                   ans.add(val.first);
                   ans.add(val.second);
                   res.add(ans);
                }
            }
        }
        int[][] result = new int[res.size()][4];
        for(int i = 0; i < res.size(); i++){
            for(int j = 0; j < 4; j++){
                result[i][j] = res.get(i).get(j);
            }
        }
        return result;
    }
}