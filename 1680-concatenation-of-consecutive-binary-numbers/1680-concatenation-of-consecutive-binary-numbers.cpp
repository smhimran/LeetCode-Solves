class Solution {
public:
    int concatenatedBinary(int n) {
        long result = 1L;
        int mod = 1000000007;
        int numberOfBits = 2;
        
        for (int i = 2; i <= n; i++) {
            if (i == (1 << numberOfBits)) {
                numberOfBits++;
            }
            
            result = ((result << numberOfBits) + i);
            
            if (result >= mod) {
                result %= mod;
            }
        }
        
        return (int) result;
    }
};