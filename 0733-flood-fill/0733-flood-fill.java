class Solution {
    Set<Pair> visited = new HashSet<>();
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int row, int column, int color, int previous) {
        if (row < 0 || column < 0) {
            return;
        }

        if (row >= image.length || column >= image[0].length) {
            return;
        }

        if (visited.contains(new Pair(row, column))) {
            return;
        }

        if (image[row][column] != previous) {
            return;
        }

        visited.add(new Pair(row, column));

        dfs(image, row + 1, column, color, image[row][column]);
        dfs(image, row - 1, column, color, image[row][column]);
        dfs(image, row, column + 1, color, image[row][column]);
        dfs(image, row, column - 1, color, image[row][column]);

        image[row][column] = color;
    }
}