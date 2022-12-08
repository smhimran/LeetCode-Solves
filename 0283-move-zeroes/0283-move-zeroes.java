class Solution {
    public void moveZeroes(int[] nums) {
        int lastNoneZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[lastNoneZeroIndex];
                nums[lastNoneZeroIndex++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}