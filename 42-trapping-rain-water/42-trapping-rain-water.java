class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        int leftMax = -1, rightMax = -1;
        
        for (int i=0, j=height.length - 1; i<height.length && j >= 0; i++, j--) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            
            left[i] = leftMax;
            right[j] = rightMax;
        }
        
        int trappedWater = 0;
        
        for (int i=0; i<height.length; i++) {
            int minHeight = Math.min(left[i], right[i]);
            trappedWater += minHeight - height[i];
        }
        
        return trappedWater;
    }
}