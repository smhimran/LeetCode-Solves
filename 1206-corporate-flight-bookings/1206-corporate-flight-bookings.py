class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        flights = []
        number_of_seats = [0] * (n + 1) 

        for booking in bookings:
            number_of_seats[booking[0] - 1] += booking[2]
            number_of_seats[booking[1]] -= booking[2]

        for i in range(1, n):
            number_of_seats[i] += number_of_seats[i - 1]

        return number_of_seats[:-1]
        