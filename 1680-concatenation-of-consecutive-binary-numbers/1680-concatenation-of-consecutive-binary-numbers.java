class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        long mod = (int) 1e9 + 7;
        long currentPowerOfTwo = 1;
        int numberOfBits = 0;
        
        for (int i = 1; i <= n; i++) {
            if (i == currentPowerOfTwo) {
                numberOfBits++;
            }
            
            result = ((result << numberOfBits) + i) % mod;
            
            if (i == currentPowerOfTwo) {
                currentPowerOfTwo *= 2;
            }
        }
        
        return (int) result;
    }
}