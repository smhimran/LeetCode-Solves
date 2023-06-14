class Solution {
    int[] dp = new int[35];

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fib(n - 1) + fib(n - 2);

        return dp[n];
    }
}