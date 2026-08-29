class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), res = 1;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        vis[0] = true;
        q.add(0);
        while(!q.isEmpty()){
            int r = q.poll();
            for(int it : rooms.get(r)){
                if(!vis[it]){
                    vis[it] = true;
                    res++;
                    q.add(it);
                }
            }
        }
        return res == n;
    }
}