class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<List<Integer>, Boolean> taken = new HashMap<>();
        int n = nums.length;
        
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> now = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    now.add(nums[j]);
                }
            }
            
            Collections.sort(now);
            
            if (!taken.containsKey(now)) {
                taken.put(now, true);
                ret.add(now);
            }
        }
        
        return ret;
    }
}