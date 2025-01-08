class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        last_position = {}

        left = 0
        right = 0

        max_length = 0

        while right < len(s):
            current = s[right]

            while last_position.get(current, -1) >= left:
                left += 1

            max_length = max(max_length, right - left + 1)

            last_position[current] = right

            right += 1

        return max_length
        