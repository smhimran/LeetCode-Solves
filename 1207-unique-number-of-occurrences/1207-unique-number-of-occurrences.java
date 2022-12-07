class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(frequency.values());
        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                return false;
            }
        }

        return true;
    }
}