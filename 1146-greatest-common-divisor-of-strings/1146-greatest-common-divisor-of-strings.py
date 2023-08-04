class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        gcdOfLengths:int = math.gcd(len(str1), len(str2))

        left = 0
        right = gcdOfLengths

        gcdString = str1[left:right]

        gcdExists = True

        while right <= len(str1):
            currentSubString = str1[left:right]

            if currentSubString != gcdString:
                gcdExists = False
                break
            
            left = right
            right += gcdOfLengths

        if gcdExists == False:
            return ""

        left = 0
        right = gcdOfLengths

        while right <= len(str2):
            currentSubString = str2[left:right]

            if currentSubString != gcdString:
                gcdExists = False
                break
            
            left = right
            right += gcdOfLengths

        if gcdExists == False:
            return ""
        
        return gcdString