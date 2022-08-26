class Solution {
    public boolean reorderedPowerOf2(int n) {
        List<Integer> powersOfTwo = Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824);
        
        for (Integer power: powersOfTwo) {
            if (isMatch(power, n)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isMatch(int x, int y) {
        int[] freqOne = new int[10];
        int[] freqTwo = new int[10];
        
        while (x > 0) {
            freqOne[(x % 10)]++;
            x /= 10;
        } 
        
        while (y > 0) {
            freqTwo[(y % 10)]++;
            y /= 10;
        }
        
        for (int i=0; i<10; i++) {
            if (freqOne[i] != freqTwo[i]) {
                return false;
            }
        }
        
        return true;
    }
}