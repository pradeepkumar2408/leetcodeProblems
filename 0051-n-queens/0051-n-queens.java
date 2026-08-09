class Solution {
    void solve(int col, List<List<String>> ans, List<String> board, int[] LeftRow, int[] LowerDiagonal, int[] UpperDiagonal, int n){
        if(col == n){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int row = 0; row < n ; row++){
            if(LeftRow[row] == 0 && LowerDiagonal[col + row] == 0 && UpperDiagonal[n - 1 + col - row] == 0){
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(col,'Q');
                board.set(row,sb.toString());
                LeftRow[row] = 1;
                LowerDiagonal[col + row] = 1;
                UpperDiagonal[n - 1 + col - row] = 1;

                solve(col + 1, ans, board, LeftRow, LowerDiagonal, UpperDiagonal, n);

                sb.setCharAt(col,'.');
                board.set(row,sb.toString());
                LeftRow[row] = 0;
                LowerDiagonal[col + row] = 0;
                UpperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String s = ".".repeat(n);
        for(int i = 0; i < n; i++){
            board.add(s);
        } 
        int[] LeftRow = new int[n];
        int[] LowerDiagonal = new int[2 * n - 1];
        int[] UpperDiagonal = new int[2 * n - 1];
        solve(0, ans, board, LeftRow, LowerDiagonal, UpperDiagonal, n);
        return ans;
    }
} 