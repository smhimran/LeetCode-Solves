class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        position = {}
        translated_words = []

        for index, i in enumerate(order):
            position[i] = index

        for word in words:
            word_in_our_alphabet = self.get_their_word_in_our_alphabet(word, position)
            translated_words.append(word_in_our_alphabet)

        return (
            sorted(translated_words)
            == translated_words
        )

    def get_their_word_in_our_alphabet(self, word: str, position_of_char: dict) -> str:
        our_alphabet = "abcdefghijklmnopqrstuvwxyz"
        their_word_in_our_alphabet = ""

        for i in word:
            position_of_current_char = position_of_char[i]
            their_word_in_our_alphabet += our_alphabet[position_of_current_char]

        return their_word_in_our_alphabet
