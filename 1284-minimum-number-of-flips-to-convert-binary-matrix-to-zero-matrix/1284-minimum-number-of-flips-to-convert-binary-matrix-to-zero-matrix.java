class Pair {
    List<List<Integer>> first;
    int second;

    Pair(List<List<Integer>> first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int minFlips(int[][] mat) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            ans.add(new ArrayList<>());
            res.add(new ArrayList<>());
            for (int j = 0; j < mat[0].length; j++) {
                ans.get(i).add(mat[i][j]);
                res.get(i).add(0);
            }
        }

        Set<List<List<Integer>>> st = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ans, 0));
        st.add(ans);

        int[] di = { -1, 0, 1, 0 }, dj = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            List<List<Integer>> ans1 = q.peek().first;
            int step = q.peek().second;
            q.remove();
            if (ans1.equals(res))
                return step;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    List<List<Integer>> temp = new ArrayList<>();

                    for (List<Integer> row : ans1) {
                        temp.add(new ArrayList<>(row));
                    }
                    temp.get(i).set(j, ans1.get(i).get(j) == 1 ? 0 : 1);
                    for (int l = 0; l < 4; l++) {
                        int ci = i + di[l], cj = j + dj[l];
                        if (ci >= 0 && ci < m && cj >= 0 && cj < n)
                            temp.get(ci).set(cj, ans1.get(ci).get(cj) == 1 ? 0 : 1);
                    }
                    if (!st.contains(temp)) {
                        st.add(temp);
                        q.add(new Pair(temp, step + 1));
                    }
                }
            }
        }
        return -1;
    }
}