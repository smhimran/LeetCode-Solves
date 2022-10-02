class Solution {
    int[][] dp = new int[35][1005];
    final int mod = 1000000007;

    public Solution() {
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
    }

    public int numRollsToTarget(int n, int k, int target) {
        return solve(0, target, k, n);
    }

    private int solve(int currentDice, int target, int k, int numberOfDice) {
        if (currentDice == numberOfDice) {
            return target == 0 ? 1 : 0;
        }

        if (dp[currentDice][target] != -1) {
            return dp[currentDice][target];
        }

        long ret = 0;

        for (int i = 1; i <= k; i++) {
            if (target - i >= 0) {
                ret += solve(currentDice + 1, target - i, k, numberOfDice);

                if (ret >= mod) {
                    ret %= mod;
                }
            }
        }

        dp[currentDice][target] = (int) ret;

        return (int) ret;
    }
}