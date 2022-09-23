class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        
        int low, high, sum, n = nums.length;
        
        Arrays.sort(nums);
        
        for (int i=0; i<n-2; i++) {
            if (i==0 || (i > 0 && nums[i] != nums[i-1])) {
                low = i + 1;
                high = n - 1;
                sum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[low]);
                        triplet.add(nums[high]);
                        
                        triplets.add(triplet);

                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }

                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }

                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }      
            }
        }
        
        return triplets;
    }
}