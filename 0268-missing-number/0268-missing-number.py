class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        sorted_nums = sorted(nums)
        
        for i in range(len(sorted_nums)):
            if sorted_nums[i] != i:
                return i

        return len(nums)
