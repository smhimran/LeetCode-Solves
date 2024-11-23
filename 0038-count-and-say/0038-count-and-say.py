class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        
        return self.generateRLE(self.countAndSay(n - 1))


    def generateRLE(self, number: str) -> str:
        rle = ""
        count = 1
        digit = number[0]

        for i in range(1, len(number)):
            if number[i] == number[i - 1]:
                count += 1
            else:
                rle += f"{count}{digit}"
                count = 1
                digit = number[i]

        rle += f"{count}{digit}"
        return rle
