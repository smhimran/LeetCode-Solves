class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        answer = 0

        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                if self.is_prefix_and_suffix(words[i], words[j]):
                    answer += 1
        
        return answer

    def is_prefix_and_suffix(self, string1, string2) -> bool:
        return string2.startswith(string1) and string2.endswith(string1)