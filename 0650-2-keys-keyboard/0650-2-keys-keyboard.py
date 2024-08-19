class Solution:
    def minSteps(self, n: int) -> int:
        return self.get_sum_of_prime_factors(n)

    def get_sum_of_prime_factors(self, n: int) -> int:
        number = n
        sum_of_prime_factors: int = 0
        sqrt = int(math.sqrt(number)) + 1

        for i in range(2, sqrt):
            while number % i == 0:
                sum_of_prime_factors += i
                number //= i

        if number > 1:
            sum_of_prime_factors += number

        return sum_of_prime_factors