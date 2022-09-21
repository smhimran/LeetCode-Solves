class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] resultOfQueries = new int[queries.length];
        int sumOfEvenNumbers = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                sumOfEvenNumbers += nums[i];
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            
            int oldValue = nums[index];
            
            if (oldValue % 2 == 0)  {
                sumOfEvenNumbers -= oldValue;
            }
            
            nums[index] = oldValue + val;
            
            if (nums[index] % 2 == 0) {
                sumOfEvenNumbers += nums[index];
         
            }
            
            resultOfQueries[i] = sumOfEvenNumbers;
        }
        
        return resultOfQueries;
    }
}