class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            nums.add(i);
        }
        
        return fun(nums, k);
    }
    
    private String fun(List<Integer> nums, int k) {
        if (nums.size() == 1) {
            return String.valueOf(nums.get(0));
        }
        
        String ret = "";
        int n = nums.size();
        int fact = factorial(n -1);
        int index = k / fact;
        
        if (k % fact == 0) {
            index -= 1;
        }
        
        ret += String.valueOf(nums.get(index));
        nums.remove(index);
        ret += fun(nums, k - (fact * index));
        
        return ret;
    }
    
    private int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        
        return n * factorial(n - 1);
    }
}