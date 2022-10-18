class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (e1, e2) -> e1[1] - e2[1]);
        int numberOfIntervalsToRemove = 0;
        int lastEnd = intervals[0][1];
                
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                numberOfIntervalsToRemove++;
            } else {
                lastEnd = intervals[i][1];
            }
        }

        return numberOfIntervalsToRemove;
    }
}