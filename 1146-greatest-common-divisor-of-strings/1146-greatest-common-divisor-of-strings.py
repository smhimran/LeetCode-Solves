class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        gcdOfLengths:int = math.gcd(len(str1), len(str2))
        gcdString = str1[0:gcdOfLengths]

        if self.isStringMultipleOfGCD(str1, gcdString) and self.isStringMultipleOfGCD(str2, gcdString):
            return gcdString
        
        return ""


    def isStringMultipleOfGCD(self, string: str, gcd: str) -> bool:
        isMultiple = True
        left = 0
        right = len(gcd)

        while right <= len(string):
            currentSubString = string[left:right]

            if currentSubString != gcd:
                isMultiple = False
                break
            
            left = right
            right += len(gcd)
        
        return isMultiple
