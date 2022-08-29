class Solution {
    private final int[] ROW = {+1,-1,+0,+0};
    private final int[] COL = {+0,+0,+1,-1};
    
    int numberOfRows = 0;
    int numberOfColumns = 0;
    
    boolean[][] visited = new boolean[305][305];
    
    public int numIslands(char[][] grid) {
        int islands = 0;
        
        numberOfRows = grid.length;
        numberOfColumns = grid[0].length;
        
        for (int i=0; i<numberOfRows; i++) {
            for (int j=0; j<numberOfColumns; j++) {
                if (grid[i][j] == '1' && !visited[i][j])  {
                    islands++;
                    dfs(i, j, grid);
                }
            }
        }
        
        return islands;
    }
    
    private void dfs(int row, int column, char[][] grid) {
        visited[row][column] = true;
        
        for (int i=0; i<4; i++) {
            int newRow = row + ROW[i];
            int newColumn = column + COL[i];
            if (isValid(newRow, newColumn) && !visited[newRow][newColumn] && grid[newRow][newColumn] == '1') {
                dfs(newRow, newColumn, grid);
            }
        }
    }
    
    private boolean isValid(int row, int column) {
        return ((row >= 0 && row < numberOfRows) && (column >= 0 && column < numberOfColumns));
    }
}