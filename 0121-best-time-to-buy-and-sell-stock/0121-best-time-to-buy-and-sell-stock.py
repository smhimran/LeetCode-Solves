class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_so_far = 10004
        profit = 0

        for price in prices:
            if price < min_so_far:
                min_so_far = price

            profit = max(profit, price - min_so_far)

        return profit