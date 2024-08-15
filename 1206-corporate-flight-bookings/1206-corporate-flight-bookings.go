func corpFlightBookings(bookings [][]int, n int) []int {
    numberOfSeats := make([]int, n + 1)

    for _, booking := range bookings {
        numberOfSeats[booking[0] - 1] += booking[2]
        numberOfSeats[booking[1]] -= booking[2]
    }

    for i := 1; i < n; i++ {
        numberOfSeats[i] += numberOfSeats[i - 1]
    }

    return numberOfSeats[:n]
}