class Solution:
    def __init__(self):
        self.leftParentheses = ["[", "{", "("]

    def isValid(self, s: str) -> bool:
        stack = []

        for bracket in s:
            if bracket in self.leftParentheses:
                stack.append(bracket)
                continue

            if len(stack) == 0 or stack[-1] != self.get_opening_bracket(bracket):
                return False

            stack.pop()

        return len(stack) == 0

    def get_opening_bracket(self, closing_bracket: str) -> str:
        if closing_bracket == ")":
            return "("
        elif closing_bracket == "}":
            return "{"

        return "["
