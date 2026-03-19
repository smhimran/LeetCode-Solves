class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = {}

        def solve(i: int):
            if i >= len(nums):
                return 0

            if i in dp:
                return dp[i]

            dp[i] = max(solve(i + 1), nums[i] + solve(i + 2))

            return dp[i]

        return solve(0)
