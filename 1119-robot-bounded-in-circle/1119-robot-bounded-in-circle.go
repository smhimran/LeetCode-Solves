func isRobotBounded(instructions string) bool {
    op := strings.Repeat(instructions, 4)

    Y := []int{+1, 0, -1, 0}
    X := []int{0, +1, 0, -1}

    var x, y, i int

    for _, o := range op {
        if o == 'G' {
            x += X[i] * 1
            y += Y[i] * 1
        } else if o == 'L' {
            i--

            if i < 0 {
                i = 3
            }
        } else if o == 'R' {
            i++

            if i > 3 {
                i = 0
            }
        }
    }

    return x == 0 && y == 0
}