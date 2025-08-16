class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        if (
            n == 1
            or n == 4
            or n == 16
            or n == 64
            or n == 256
            or n == 1024
            or n == 4096
            or n == 16384
            or n == 65536
            or n == 262144
            or n == 1048576
            or n == 4194304
            or n == 16777216
            or n == 67108864
            or n == 268435456
            or n == 1073741824
        ):
            return True
        return False
