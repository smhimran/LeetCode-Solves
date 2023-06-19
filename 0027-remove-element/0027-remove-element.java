class Solution {
    public int removeElement(int[] nums, int val) {
        int next = 0;
        int now = 0;
        int numberOfNonVal = 0;

        while (now < nums.length && nums[now] != val) {
            now++;
            numberOfNonVal++;
        }
        
        next = now;

        while (next < nums.length && nums[next] == val) {
            next++;
        }

        for (; next < nums.length; next++) {
            if (nums[next] == val) {
               continue;
            }

            nums[now] = nums[next];
            nums[next] = val;
            
            numberOfNonVal++;
            now++;
        }

        return numberOfNonVal;
    }
}