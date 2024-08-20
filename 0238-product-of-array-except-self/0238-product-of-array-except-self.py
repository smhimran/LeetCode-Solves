class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        result = []
        product = 1

        for num in nums:
            result.append(product)
            product *= num

        product = 1
        index = len(nums) - 1

        for num in reversed(nums):
            result[index] *= product
            product *= num
            index -= 1
        
        return result