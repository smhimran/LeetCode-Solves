class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        subs_of_other_words = []

        for word in words:
            if self.is_substring_of_any(word, words):
                subs_of_other_words.append(word)

        return subs_of_other_words

    def is_substring_of_any(self, string: str, words: List[str]):
        for word in words:
            if string != word and string in word:
                return True

        return False
