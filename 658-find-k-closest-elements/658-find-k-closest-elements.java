class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = -1, minimumDifference = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i] - x) < minimumDifference) {
                index = i;
                minimumDifference = Math.abs(arr[i] - x);
            }
        }
        
        List<Integer> ret = new ArrayList<>();
        
        int i = index, j = index + 1;
        int remaining = k;
        
        while (remaining > 0) {
            int before = i >= 0 ? arr[i] : Integer.MAX_VALUE;
            int after = j < arr.length ? arr[j] : Integer.MAX_VALUE;
            
            if (before == Integer.MAX_VALUE) {
                ret.add(after);
                j++;
            } else if (after == Integer.MAX_VALUE) {
                ret.add(before);
                i--;
            } else if (Math.abs(x - before) <= Math.abs(x - after)) {
                ret.add(before);
                i--;
            } else {
                ret.add(after);
                j++;
            }
            
            remaining--;
        }
        
        Collections.sort(ret);
        return ret;
    }
}