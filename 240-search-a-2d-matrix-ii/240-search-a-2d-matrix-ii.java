class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;

        int row = 0;
        int column = numberOfColumns - 1;

        while (row < numberOfRows && column >= 0) {
            int currentValue = matrix[row][column];

            if (currentValue == target) {
                return true;
            } else if (currentValue < target) {
                row++;
            } else {
                column--;
            }
        }

        return false;
    }
}