class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        number = digits[::-1]
        carry = 1

        for i in range(len(number)):
            current = number[i] + carry
            number[i] = current % 10 
            carry = current // 10

        if carry:
            number.append(carry) 

        return number[::-1]
