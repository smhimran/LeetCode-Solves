class Solution {
    public int removeDuplicates(int[] nums) {
        int position = 0;
        boolean isPreviousSame = false;

        for (int i = 1; i < nums.length; i++) {
            boolean isCurrentSame = (nums[position] == nums[i]);

            if (!isCurrentSame || !isPreviousSame) {
                nums[++position] = nums[i];
            }

            isPreviousSame = isCurrentSame;
        }

        return position + 1;
    }
}