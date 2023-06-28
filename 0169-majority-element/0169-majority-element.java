class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, position = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[position]) {
                count++;
            } else {
                count--;

                if (count < 1) {
                    count = 1;
                    position = i;
                }
            }
        }

        return nums[position];
    }
}