class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        fun(candidates, 0, target, subset, subsets);
        
        return subsets;
    }
    
    private void fun(int[] nums, int i, int target, List<Integer> subset, List<List<Integer>> subsets) {
        if (0 == target) {
            subsets.add(new ArrayList<>(subset));
            return;
        }
        
        for (int j=i; j<nums.length; j++) {
            if (j > i && nums[j] == nums[j-1])
                continue;
            if (nums[j] > target)
                break;
            subset.add(nums[j]);
            fun(nums, j + 1, target - nums[j], subset, subsets);
            subset.remove(subset.size() - 1);
        }        
    }
}