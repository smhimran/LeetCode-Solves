class Solution {    
    public void solveSudoku(char[][] board) {        
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int row=0; row<9; row++) {
            for (int column=0; column<9; column++) {
                if (board[row][column] == '.') {
                    for (char c='1'; c<='9'; c++) {
                        if (isValid(board, row, column, c)) {
                            
                            board[row][column] = c;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][column] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int column, char c) {
        for (int i=0; i<9; i++) {
            if (board[row][i] == c) {
                return false;
            }
            
            if (board[i][column] == c) {
                return false;
            }
            
            if (board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}