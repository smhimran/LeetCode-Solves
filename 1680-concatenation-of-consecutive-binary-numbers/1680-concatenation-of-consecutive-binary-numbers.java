class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        int numberOfBits = 0;
        
        for (int i = 1; i <= n; i++) {
            if (i == (1 << numberOfBits)) {
                numberOfBits++;
            }
            
            result = ((result << numberOfBits) + i);
            
            if (result >= 1000000007) {
                result = (result-(result/1000000007)*1000000007);
            }
        }
        
        return (int) result;
    }
}