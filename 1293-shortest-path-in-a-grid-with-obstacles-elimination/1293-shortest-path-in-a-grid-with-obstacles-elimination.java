class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        boolean[][][] visited = new boolean[n + 1][m + 1][k + 1];

        int[] ROW = {+1,-1,+0,+0};
        int[] COL = {+0,+0,+1,-1};
        
        Queue<Cell> queue = new LinkedList<>();

        queue.add(new Cell(0, 0, k, 0));

        while (!queue.isEmpty()) {
            Cell now = queue.poll();

            if (now.row == n - 1 && now.column == m - 1) {
                return now.level;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = now.row + ROW[i];
                int newColumn = now.column + COL[i];

                if (isValid(newRow, newColumn, n, m)) {
                        if (grid[newRow][newColumn] == 1) {
                            if (now.k > 0) {
                                if (!visited[newRow][newColumn][now.k - 1]) {
                                    queue.add(new Cell(newRow, newColumn, now.k - 1, now.level + 1));
                                    visited[newRow][newColumn][now.k - 1] = true;
                                }
                            }
                        } else {
                            if (!visited[newRow][newColumn][now.k]) {
                                queue.add(new Cell(newRow, newColumn, now.k, now.level + 1));
                                visited[newRow][newColumn][now.k] = true;
                            }
                        }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int row, int column, int maxRow, int maxColumn) {
        if (row < 0 || row >= maxRow)
            return false;
        if (column < 0 || column >= maxColumn)
            return false;
        return true;
    }
}

class Cell {
    int row, column, k, level;

    public Cell(int row, int column, int k, int level) {
        this.row = row;
        this.column = column;
        this.k = k;
        this.level = level;
    }

    public String toString(){
        return row + " " + column + " " + k + " " + level;
    }
}