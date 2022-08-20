class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Map<List<Integer>, Boolean> taken = new HashMap<>();
        
        fun(candidates, 0, 0, target, subset, subsets, taken);
        
        return subsets;
    }
    
    private void fun(int[] nums, int i, int sum, int target, List<Integer> subset, List<List<Integer>> subsets, Map<List<Integer>, Boolean> taken) {
        if (sum >= target || i == nums.length) {
            if (sum == target && !taken.containsKey(subset)) {
                subsets.add(new ArrayList<>(subset));
                taken.put(subset, true);
            }
            return;
        }
        
        subset.add(nums[i]);
        fun(nums, i, sum + nums[i], target, subset, subsets, taken);
        fun(nums, i + 1, sum + nums[i], target, subset, subsets, taken);
        subset.remove(subset.size() - 1);
        fun(nums, i + 1, sum, target, subset, subsets, taken);
    }
}