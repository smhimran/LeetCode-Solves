class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        
        getPermutation(nums, 0, permutations);
        
        return permutations;
    }
    
    private void getPermutation(int[] nums, int i, List<List<Integer>> permutations) {
        if (i == nums.length) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            permutations.add(list);
            return;
        }
        
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            
            getPermutation(nums, i + 1, permutations);
            
            swap(nums, i, j);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}