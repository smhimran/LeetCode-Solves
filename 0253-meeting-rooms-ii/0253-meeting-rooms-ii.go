import (
    "sort"
)

type Time struct {
    value int
    start bool
}

func minMeetingRooms(intervals [][]int) int {
    var times []Time
    numberOfOngoingMeetings := 0
    maximumNumberOfMeetings := 0

    for _, interval := range intervals {
        times = append(times, Time{interval[0], true})
        times = append(times, Time{interval[1], false})
    }    

    sort.Slice(times, func(i, j int) bool {
        if times[i].value == times[j].value {
            return !times[i].start && times[j].start
        }
        return times[i].value < times[j].value
    })

    for _, time := range times {
        if time.start {
            numberOfOngoingMeetings++
        } else {
            numberOfOngoingMeetings--
        }

        maximumNumberOfMeetings = max(maximumNumberOfMeetings, numberOfOngoingMeetings)
    }

    return maximumNumberOfMeetings
}