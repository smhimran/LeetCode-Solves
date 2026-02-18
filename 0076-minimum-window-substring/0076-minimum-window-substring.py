class Solution:
    def minWindow(self, s: str, t: str) -> str:
        t_freq = defaultdict(int)
        freq = defaultdict(int)

        for i in t:
            t_freq[i] += 1

        left = 0
        right = 0

        required = len(t_freq)
        formed = 0

        min_length = len(s) + 1
        min_sub = ""

        while right < len(s):
            char = s[right]

            freq[char] += 1

            if t_freq[char] > 0 and freq[char] == t_freq[char]:
                formed += 1

            while left <= right and formed == required:
                length = right - left + 1

                if length < min_length:
                    min_length = length
                    min_sub = s[left : right + 1]

                left_char = s[left]
                freq[left_char] -= 1

                if left_char in t_freq and freq[left_char] < t_freq[left_char]:
                    formed -= 1

                left += 1

            right += 1

        return min_sub
