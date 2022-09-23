class Solution {
public:
    int concatenatedBinary(int n) {
        long result = 1L, numberOfBits = 1;
        
        for (long i = 2; i <= n; i++) {
            if (i == (1 << numberOfBits)) {
                numberOfBits++;
            }
            
            result = (result << numberOfBits) + i;
            
            if (result >= 1000000007) {
                result = result - (result / 1000000007) * 1000000007;
            }
        }
        
        return result;
    }
};