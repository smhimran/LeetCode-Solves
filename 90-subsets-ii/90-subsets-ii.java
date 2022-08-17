class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        
        Arrays.sort(nums);
        
        fun(nums, 0, nums.length, subset, subsets);
        
        return subsets;
    }
    
    private void fun(int[] nums, int i, int n, List<Integer> subset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(subset));
        
        for (int j=i; j<n; j++) {
            if (j > i && (nums[j] == nums[j-1]))
                continue;
            
            subset.add(nums[j]);
            fun(nums, j+1, n, subset, subsets);
            subset.remove(subset.size() - 1);
        }
    }
}