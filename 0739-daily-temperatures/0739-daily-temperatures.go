type Day struct {
    temperature int
    index int
}

func dailyTemperatures(temperatures []int) []int {
    var stack []Day
    result := make([]int, len(temperatures))

    for i, temp := range temperatures {
        for len(stack) > 0 && stack[len(stack)-1].temperature < temp {
            top := stack[len(stack)-1]
            result[top.index] = i - top.index
            stack = stack[:len(stack)-1]
        }
        stack = append(stack, Day{temperature: temp, index: i})
    }

    return result
}