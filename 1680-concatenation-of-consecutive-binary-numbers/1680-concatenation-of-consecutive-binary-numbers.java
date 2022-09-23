class Solution {
    public int concatenatedBinary(int n) {
        int result = 0;
        int mod = (int) 1e9 + 7;
        
        for (int i = 1; i <= n; i++) {
            boolean started = false;
            for (int j = 31; j >= 0; j--) {
                int val = (1 & (i >> j));
                if (val == 1) {
                    started = true;
                }
                
                if (started) {
                    result = (result * 2 + val) % mod;
                }
            }
        }
        
        return result;
    }
}