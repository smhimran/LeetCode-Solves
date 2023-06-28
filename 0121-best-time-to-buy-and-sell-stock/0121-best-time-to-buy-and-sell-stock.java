class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, min_so_far = Integer.MAX_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_so_far) {
                min_so_far = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min_so_far);
            }
        }
        
        return profit;
    }
}