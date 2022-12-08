class Solution {
    public void moveZeroes(int[] nums) {
        int nextNoneZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                while (nextNoneZeroIndex < nums.length && nums[nextNoneZeroIndex] == 0) {
                    nextNoneZeroIndex++;
                }

                if (nextNoneZeroIndex < nums.length) {
                    int temp = nums[nextNoneZeroIndex];
                    nums[nextNoneZeroIndex] = nums[i];
                    nums[i] = temp;

                    nextNoneZeroIndex++;
                }
            } else {
                nextNoneZeroIndex++;
            }
        }
    }
}