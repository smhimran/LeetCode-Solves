class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        long mod = (int) 1e9 + 7;
        int numberOfBits = 0;
        
        for (int i = 1; i <= n; i++) {
            if (i == (1 << numberOfBits)) {
                numberOfBits++;
            }
            
            result = ((result << numberOfBits) + i) % mod;
        }
        
        return (int) result;
    }
}