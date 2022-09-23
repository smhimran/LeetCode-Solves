class Solution {
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length - 1, temp;
        
        while (white <= blue) {
            if (nums[white] == 0) {
                temp = nums[red];
                nums[red] = nums[white];
                nums[white] = temp;
                
                red++;
                white++;
            } else if (nums[white] == 2) {
                temp = nums[blue];
                nums[blue] = nums[white];
                nums[white] = temp;
                
                blue--;
            } else {
                white++;
            }
        }
    }
}