class Solution:
    def __init__(self):
        self.dp = [None] * 101
        self.house = []

    def rob(self, nums: List[int]) -> int:
        self.house = nums
        return self.solve(0)

    def solve(self, i: int):
        if (i >= len(self.house)):
            return 0

        if self.dp[i] is not None:
            return self.dp[i]

        self.dp[i] = 0

        robbed = self.solve(i + 1)
        robbed = max(robbed, self.house[i] + self.solve(i + 2))

        self.dp[i] = robbed

        return robbed