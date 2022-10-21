class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> prev = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int index = prev.getOrDefault(nums[i], -1);

            if (index != -1) {
                if (Math.abs(i - index) <= k) {
                    return true;
                }
            }

            prev.put(nums[i], i);
        }

        return false;
    }
}