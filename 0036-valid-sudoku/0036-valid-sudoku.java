class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[10][10];
        boolean[][] column = new boolean[10][10];
        boolean[][] grid = new boolean[10][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - '0';
                    
                    if (row[i][value] || column[j][value] || grid[getGrid(i, j)][value]) {
                        return false;
                    }

                    row[i][value] = true;
                    column[j][value] = true;
                    grid[getGrid(i, j)][value] = true;
                }
            }
        }

        return true;
    }

    private int getGrid(int row, int column) {
        return ((row / 3) * 3) + (column / 3);
    }
}