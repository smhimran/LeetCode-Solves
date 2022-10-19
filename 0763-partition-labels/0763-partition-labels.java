class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> firstAppearance = new HashMap<>();
        Map<Character, Integer> lastAppearance = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            firstAppearance.putIfAbsent(s.charAt(i), i);
            lastAppearance.put(s.charAt(i), i);
        }

        List<Integer> partitions = new ArrayList<>();

        int charsNotEnded = 0, previous = 0;

        for (int i = 0; i < s.length(); i++) {
            int first = firstAppearance.get(s.charAt(i));
            int last = lastAppearance.get(s.charAt(i));

            if (first == i) {
                charsNotEnded++;
            }

            if (last == i) {
                charsNotEnded--;
            }

            if (charsNotEnded == 0) {
                partitions.add((i + 1 - previous));
                previous = i + 1;
            }
        }

        return partitions;
    }
}