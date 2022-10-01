class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];

        if (s.charAt(0) != '0') {
            dp[0] = 1;
        }
        
        for (int i = 1; i <= s.length(); i ++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            if (i > 1) {
                if (s.charAt(i - 2) != '0') {
                    String numberWithPreviousDigitAsString = "" + s.charAt(i - 2) + s.charAt(i - 1);
                    int numberWithPreviousDigit = Integer.parseInt(numberWithPreviousDigitAsString);
                    if (numberWithPreviousDigit >= 1 && numberWithPreviousDigit <= 26) {
                        dp[i] += dp[i - 2];
                    }
                } else if (s.charAt(i - 1) == '0') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[s.length()];
    }
}