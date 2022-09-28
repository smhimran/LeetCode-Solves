class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        int startNow = intervals[0][0], endNow = intervals[0][1];
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 1; i < intervals.length; i++) {
            if (endNow < intervals[i][0]) {
                result.add(List.of(startNow, endNow));
                startNow = intervals[i][0];
                endNow = intervals[i][1];
            } else {
                endNow = Math.max(endNow, intervals[i][1]);
            }
        }
        
        result.add(List.of(startNow, endNow));
        
        int[][] ret = new int[result.size()][2];
        
        for (int i = 0; i < result.size(); i++) {
            ret[i][0] = result.get(i).get(0);
            ret[i][1] = result.get(i).get(1);
        }
        
        return ret;
    }
}