class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        times = []
        numberOfOngoingMeetings = 0
        maximumNumberOfMeetings = 0
        
        for interval in intervals:
            times.append([interval[0], "start"])
            times.append([interval[1], "end"])

        times.sort()
        
        for time in times:
            if time[1] == "start":
                numberOfOngoingMeetings += 1
            else:
                numberOfOngoingMeetings -= 1
            maximumNumberOfMeetings = max(maximumNumberOfMeetings, numberOfOngoingMeetings)

        return maximumNumberOfMeetings
