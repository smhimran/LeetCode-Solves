class Solution {
    int[][] dp = new int[105][105];
    boolean[][] visited = new boolean[105][105];

    public int minFallingPathSum(int[][] matrix) {
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < matrix[0].length; i++) {
            minSum = Math.min(minSum, failingSum(matrix, 0, i));
        }

        return minSum;
    }

    private int failingSum(int[][] matrix, int i, int j) {
        if (j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == matrix.length - 1) {
            return matrix[i][j];
        }

        if (visited[i][j]) {
            return dp[i][j];
        }

        visited[i][j] = true;

        int ret = Integer.MAX_VALUE;

        ret = Math.min(ret, failingSum(matrix, i + 1, j));
        ret = Math.min(ret, failingSum(matrix, i + 1, j - 1));
        ret = Math.min(ret, failingSum(matrix, i + 1, j + 1));

        dp[i][j] = ret + matrix[i][j];

        return dp[i][j];
    }
}