class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        int n = profit.length;

        for (int i = 0; i < n; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(jobs, (a, b) -> a.getEnd() - b.getEnd());

        int[] dp = new int[n + 1];
        dp[0] = jobs.get(0).getProfit();

        for (int i = 1; i < n; i++) {
            Job currentJob = jobs.get(i);
            dp[i] = Math.max(dp[i - 1], currentJob.getProfit());
            
            for (int j = i - 1; j >= 0; j--) {
                if (jobs.get(j).getEnd() <= currentJob.getStart()) {
                    dp[i] = Math.max(dp[i], dp[j] + currentJob.getProfit());
                    break;
                }
            }
        }

        return dp[n - 1];
    }

    private class Job {
        private int start;
        private int end;
        private int profit;

        public Job() {

        }

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getProfit() {
            return profit;
        }
    }
}