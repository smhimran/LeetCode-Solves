class Solution {
    private final Set<Pair> visited = new HashSet<>();
    private int currentArea;

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                currentArea = 0;
                dfs(grid, i, j);
                maxArea = Math.max(maxArea, currentArea);
            }
        }

        return maxArea;
    }

    private void dfs(int[][] grid, int row, int column) {
        if (row < 0 || column < 0) {
            return;
        }

        if (row >= grid.length || column >= grid[0].length) {
            return;
        }

        if (grid[row][column] == 0) {
            return;
        }

        if (visited.contains(new Pair(row, column))) {
            return;
        }

        visited.add(new Pair(row, column));
        currentArea++;

        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }
}