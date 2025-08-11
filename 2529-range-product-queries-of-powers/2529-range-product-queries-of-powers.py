MOD = 1000000007


class Solution:
    def productQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        powers_in_sum = self.get_powers_in_sum(n)
        answers = []

        for query in queries:
            answer = 1

            for i in range(query[0], query[1] + 1):
                answer = (answer * powers_in_sum[i]) % MOD
            
            answers.append(answer)

        return answers
        

    def get_powers_in_sum(self, n: int) -> List[int]:
        powers_of_two = self.get_powers_of_two()
        powers_in_sum = []

        for power in powers_of_two:
            multiple = n // power

            for i in range(multiple):
                powers_in_sum.append(power)
                n -= power

        powers_in_sum.reverse()

        return powers_in_sum

    def get_powers_of_two(self) -> List[int]:
        base = 1
        powers_of_two = []

        for i in range(32):
            powers_of_two.append(base)
            base *= 2

        powers_of_two.reverse()
        return powers_of_two
