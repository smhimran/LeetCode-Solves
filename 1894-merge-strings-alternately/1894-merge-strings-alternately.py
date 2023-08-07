class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        pointer1 = 0
        pointer2 = 0
        merged_string = ""

        while pointer1 < len(word1) and pointer2 < len(word2):
            merged_string += word1[pointer1]
            merged_string += word2[pointer2]

            pointer1 += 1
            pointer2 += 1

        merged_string = self.appendRestOfTheWord(word1, merged_string, pointer1)
        merged_string = self.appendRestOfTheWord(word2, merged_string, pointer2)

        return merged_string

    
    def appendRestOfTheWord(self, word: str, target: str, pointer: int) -> str:
        while pointer < len(word):
            target += word[pointer]
            pointer += 1

        return target