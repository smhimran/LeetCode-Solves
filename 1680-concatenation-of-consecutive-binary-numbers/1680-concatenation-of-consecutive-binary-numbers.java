class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        long mod = (int) 1e9 + 7;
        long currentPowerOfTwo = 1;
        int numberOfBits = 0;
        
        for (int i = 1; i <= n; i++) {
            if (i == currentPowerOfTwo) {
                numberOfBits++;
                currentPowerOfTwo *= 2;
            }
            
            result = ((result << numberOfBits) + i) % mod;
        }
        
        return (int) result;
    }
}