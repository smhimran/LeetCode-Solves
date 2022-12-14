class Solution {
    int[][] dp = new int[400][2];
    boolean[][] visited = new boolean[400][2];

    public int rob(int[] nums) {
        return maximumProfit(nums, 0, false);
    }

    private int maximumProfit(int[] nums, int i, boolean previousWasTaken) {
        if (i == nums.length) {
            return 0;
        }

        if (visited[i][previousWasTaken ? 1: 0]) {
            return dp[i][previousWasTaken ? 1 : 0];
        }

        int profit = 0;
        visited[i][previousWasTaken ? 1: 0] = true;

        if (!previousWasTaken) {
            profit = nums[i] + maximumProfit(nums, i + 1, true);
        }
        profit = Math.max(profit, maximumProfit(nums, i + 1, false));
        dp[i][previousWasTaken ? 1 : 0] = profit;

        return profit;
    }
}