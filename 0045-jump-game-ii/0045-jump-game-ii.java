class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Queue<Pair> q = new LinkedList<>();
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        boolean[] vis = new boolean[n];
        vis[0] = true;
        q.add(new Pair(0, 1));

        while (!q.isEmpty()) {
            int index = q.peek().first, val = q.peek().second;
            q.remove();
            for (int i = index + 1; i <= index + nums[index] && i < n; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    dp[i] = val;
                    q.add(new Pair(i, val + 1));
                }
            }
        }
        return dp[n - 1];
    }
}