class Solution {
    public int[] findBall(int[][] grid) {
        int[] out = new int[grid[0].length];


        for (int column = 0; column < grid[0].length; column++) {
            int currentColumn = column;
            for (int row = 0; row < grid.length; row++) {
                int next = currentColumn + grid[row][currentColumn];

                if (next < 0 || next >= grid[0].length || grid[row][next] != grid[row][currentColumn]) {
                    out[column] = -1;
                    break;
                }

                out[column] = next;
                currentColumn = next;
            }
        }

        return out;
    }
}