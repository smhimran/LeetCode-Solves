class Solution {
    public int removeElement(int[] nums, int val) {
        int next = 0;
        int now = 0;

        // Find first index with val
        while (now < nums.length && nums[now] != val) {
            now++;
        }
        
        next = now;

        // Find first index without val after 'now'
        while (next < nums.length && nums[next] == val) {
            next++;
        }

        // For each index, find next non val, swap with now, and increment now by one
        for (; next < nums.length; next++) {
            if (nums[next] == val) {
               continue;
            }

            nums[now] = nums[next];
            nums[next] = val;

            now++;
        }

        return now;
    }
}