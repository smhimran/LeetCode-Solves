class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {
            int index = Arrays.binarySearch(matrix[i], target);
            found |= (index >= 0);
        }
        
        return found;
    }
}