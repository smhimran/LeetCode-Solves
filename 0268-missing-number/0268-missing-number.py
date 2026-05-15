class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        sorted_nums = [-1] * len(nums)

        for i in nums:
            if i == len(nums):
                sorted_nums[-1] = i
                continue

            sorted_nums[i] = i

        for index, i in enumerate(sorted_nums):
            if i != index:
                return index

        return len(nums)
