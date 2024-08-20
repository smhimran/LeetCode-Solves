from collections import defaultdict

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequency = defaultdict(int)

        for num in nums:
            frequency[num] += 1

        frequent_elements = sorted(
            frequency, 
            key=lambda key: frequency[key], 
            reverse=True
        )

        return frequent_elements[:k]
        