class Solution {
    public int[][] generateMatrix(int n) {
        int row = 0, column = 0;
        int minimumRow = 0, maximumRow = n - 1;
        int minimumColumn = 0, maximumColumn = n - 1;

        int[][] matrix = new int[n][n];

        String direction = "RIGHT";

        for (int i = 1; i <= n * n; i++) {
            matrix[row][column] = i;

            if (row == maximumRow && direction.equals("DOWN")) {
                direction = "LEFT";
                maximumRow--;
            }

            if (row == minimumRow + 1 && direction.equals("UP")) {
                direction = "RIGHT";
                minimumRow++;
            } 

            if (column == maximumColumn && direction.equals("RIGHT")) {
                direction = "DOWN";
                maximumColumn--;
            } 

            if (column == minimumColumn && direction.equals("LEFT")) {
                direction = "UP";
                minimumColumn++;
            }

            switch (direction) {
                case "UP":
                    row--;
                    break;
                case "DOWN":
                    row++;
                    break;
                case "LEFT":
                    column--;
                    break;
                case "RIGHT":
                    column++;
                    break;            
            }
        }

        return matrix;
    }
}