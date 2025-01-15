class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        num1_binary = to_binary(num1)
        remaining_bits = number_of_set_bits(num2)

        x_binary = ""

        for bit in num1_binary:
            if bit == "1" and remaining_bits > 0:
                x_binary += "1"
                remaining_bits -= 1

            else:
                x_binary += "0"

        for i in reversed(range(len(num1_binary))):
            if x_binary[i] == "0" and remaining_bits > 0:
                x_binary = x_binary[:i] + "1" + x_binary[i + 1 :]
                remaining_bits -= 1

        if remaining_bits > 0:
            x_binary = ("1" * remaining_bits) + x_binary

        return to_decimal(x_binary)


def to_binary(num: int) -> str:
    return bin(num).replace("0b", "")


def to_decimal(string: str) -> int:
    return int(string, 2)


def number_of_set_bits(num: int) -> int:
    return sum([1 for bit in to_binary(num) if bit == "1"])
