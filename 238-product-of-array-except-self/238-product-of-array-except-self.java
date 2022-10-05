class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int previous = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            product[i] = nums[i] * previous;
            previous = product[i];
        }

        previous = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            product[i] = previous * product[i + 1];
            previous *= nums[i];
        }

        product[nums.length - 1] = previous;

        return product;
    }
}