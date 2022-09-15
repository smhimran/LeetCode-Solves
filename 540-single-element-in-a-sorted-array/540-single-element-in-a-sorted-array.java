class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        int left = 0, right = nums.length - 2, ans = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (mid % 2 != 0) {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }  
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return nums[left];
    }
}