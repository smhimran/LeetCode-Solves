class Solution:
    def xorAllNums(self, nums1: List[int], nums2: List[int]) -> int:
        nums1_zeroes = [0] * 32
        nums1_ones = [0] * 32

        nums2_zeroes = [0] * 32
        nums2_ones = [0] * 32

        for num in nums1:
            count_bits(num, nums1_zeroes, nums1_ones)
            
        for num in nums2:
            count_bits(num, nums2_zeroes, nums2_ones)

        result_binary = ""

        for i in reversed(range(32)):
            ones = (nums1_ones[i] * nums2_zeroes[i]) + (nums2_ones[i] * nums1_zeroes[i])

            result_binary += "0" if ones % 2 == 0 else "1"

        return int(result_binary, 2)


def count_bits(number: int, zeroes: list, ones: list):
    for i in reversed(range(32)):
        bit = number & (1 << i)

        if bit != 0:
            ones[i] += 1
        else:
            zeroes[i] += 1
