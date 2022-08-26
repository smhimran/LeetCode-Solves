class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        List<String> board = new ArrayList<>();
        int[][] markedBoard = new int[n + 5][n + 5];
        

        
        for (int i=0; i<n; i++) {
            String row = "";
            for (int j=0; j<n; j++) {
                row += ".";
            }
            board.add(row);
        }
        
        solve(n, 0, n, board, markedBoard, solution);
        return solution;
    }
    
    private void solve(int n, int row, int queens, List<String> board, int[][] markedBoard, List<List<String>> solution) {
        if (row == n) {
            if (queens == 0) {
                List<String> aSingleSolution = new ArrayList<>();
                
                for (String singleRow: board){
                    String now = new String(singleRow);
                    aSingleSolution.add(now);
                }
                    
                solution.add(aSingleSolution);
            }
            
            return;
        }
        
        for (int i=0; i<n; i++) {
            if (markedBoard[row][i] == 0) {
                mark(markedBoard, row, i, 1);
                String currentRow = board.get(row);
                StringBuilder builder = new StringBuilder(currentRow);
                builder.setCharAt(i, 'Q');
                currentRow = builder.toString();
                board.set(row, currentRow);
                
                solve(n, row + 1, queens - 1, board, markedBoard, solution);
                
                mark(markedBoard, row, i, -1);
                currentRow = board.get(row);
                builder = new StringBuilder(currentRow);
                builder.setCharAt(i, '.');
                currentRow = builder.toString();
                board.set(row, currentRow);
            }
        }
    }
    
    private void mark(int[][] board, int row, int column, int val) {
        int n = board.length;
        int m = board[0].length;
        
        for (int i=0; i<n; i++) {
            board[i][column] += val;
        }
        
        for (int j=0; j<m; j++) {
            board[row][j] += val;
        }
        
        for (int i=row, j=column; i<n && j<m; i++, j++) {
            board[i][j] += val;
        }
        
        for (int i=row, j=column; i>=0 && j<m; i--, j++) {
            board[i][j] += val;
        }
        
        for (int i=row, j=column; i<n && j>=0; i++, j--) {
            board[i][j] += val;
        }
        
        for (int i=row, j=column; i>=0 && j>=0; i--, j--) {
            board[i][j] += val;
        }
    }
}