class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Long, Integer>[] dp = new HashMap[nums.length];

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];

                if (diff >= Integer.MIN_VALUE && diff <= Integer.MAX_VALUE) {
                    int current = dp[i].getOrDefault(diff, 0);
                    int earlier = dp[j].getOrDefault(diff, 0);

                    dp[i].put(diff, current + earlier + 1);
                    ans += earlier;
                }

            }
        }

        return ans;
    }
}