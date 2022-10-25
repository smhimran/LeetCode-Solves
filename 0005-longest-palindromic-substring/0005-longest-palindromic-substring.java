class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, max = 1;
        boolean dp[][] = new boolean[n + 1][n + 1];

            
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                
                if (s.charAt(i) == s.charAt(j) && (j == i + 1 || (dp[i+1][j-1] == true))) {
                    dp[i][j] = true;
                    
                    if ((j - i) + 1 > max) {
                        max = (j - i) + 1;
                        start = i;
                    }
                }
            }
        }
        
        String ret = s.substring(start, start + max);
        
        return ret;
    }
}