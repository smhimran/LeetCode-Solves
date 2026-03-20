class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        product = []
        product_till_now = 1

        for i in nums:
            product.append(product_till_now)
            product_till_now *= i

        product_till_now = 1

        for i in range(len(nums) - 1, -1, -1):
            product[i] *= product_till_now
            product_till_now *= nums[i]

        return product
