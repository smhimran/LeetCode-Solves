class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] ret = new int[nums.length];
        int numberOfElementsInRange = (2 * k) + 1;

        long sum = 0;
        int i = 0;

        for (; i < nums.length && i < k; i++) {
            ret[i] = -1;
            sum += nums[i];
        }

        int j = k;

        while (j < nums.length && j < numberOfElementsInRange) {
            sum += nums[j];
            j++;
        }


        if (numberOfElementsInRange - 1 < nums.length) {
            ret[k] = (int) (sum / numberOfElementsInRange);
        } else if (k < nums.length) {
            ret[k] = -1;
        }

        i++;

        for (; j < nums.length; i++, j++) {
            sum += (nums[j] - nums[i - k - 1]);
            int average = (int) (sum / numberOfElementsInRange);
            ret[i] = average;
        }

        while (i < nums.length) {
            ret[i] = - 1;
            i++;
        }

        return ret;
    }
}