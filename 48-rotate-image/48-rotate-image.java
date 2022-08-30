class Solution {
    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix[0].length - 1;
        
        while (start < end) {
            rotateLayer(matrix, start, end);
            
            start++;
            end--;
        }
    }
    
    private void rotateLayer(int[][] matrix, int start, int end) {
        int n = end - start;
        
        for (int k = 0; k < n; k++) {
            int i = start, j = start;
            
            int temp = matrix[i][j];
            while (j < end) {
                int now = matrix[i][j];
                matrix[i][j] = temp;
                temp = now;
                
                j++;
            }
            
            while (i < end) {
                int now = matrix[i][j];
                matrix[i][j] = temp;
                temp = now;
                
                i++;
            }
            
            while (j > start) {
                int now = matrix[i][j];
                matrix[i][j] = temp;
                temp = now;
                
                j--;
            }
            
            while (i > start) {
                int now = matrix[i][j];
                matrix[i][j] = temp;
                temp = now;
                
                i--;
            }
            
            matrix[i][j] = temp;
        }
    }
}