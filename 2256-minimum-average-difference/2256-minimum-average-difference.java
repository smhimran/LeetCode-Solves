class Solution {
    public int minimumAverageDifference(int[] nums) {
        long totalSum = 0;
        int n = nums.length;
        long[] sum = new long[n + 2];

        for (int i = 1; i <= n; i++) {
            totalSum += nums[i - 1];
            sum[i] = totalSum;
        }

        int ans = -1;
        long minSofar = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            long leftSum = sum[i];
            long rightSum = totalSum - leftSum;
            long leftAverage = leftSum / i;
            long rightAverage = rightSum / Math.max((n - i), 1);
            long diff = Math.abs(leftAverage - rightAverage);

            if (diff < minSofar) {
                minSofar = diff;
                ans = i - 1;
            }
        }

        return ans;
    }
}