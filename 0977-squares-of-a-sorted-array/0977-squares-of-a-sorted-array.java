class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                int sqr = nums[i] * nums[i];
                list.add(sqr);
            }
        }

        int index = list.size() - 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                break;
            } else {
                int sqr = nums[i] * nums[i];
                while (index >= 0 && list.get(index) > sqr) {
                    index--;
                }

                if (index == list.size() - 1) {
                    list.add(sqr);
                    index++;
                } else {
                    list.add(index + 1, sqr);
                }
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}