class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_so_far = prices[0]
        maximum_profit = 0

        for price in prices:
            if price < min_so_far:
                min_so_far = price

            maximum_profit = max(maximum_profit, price - min_so_far)

        return maximum_profit