class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        return '0' if all(num == 0 for num in nums) else ''.join(sorted(map(str, nums), key=lambda x: x*10, reverse=True))
