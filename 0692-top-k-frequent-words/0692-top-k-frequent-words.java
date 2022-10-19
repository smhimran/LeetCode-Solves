class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap<>();

        for (String word: words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<String> uniqueWords = new ArrayList<>(frequency.keySet());
        Collections.sort(uniqueWords, (e1, e2) -> {
            if (frequency.get(e2) == frequency.get(e1)) {
                return e1.compareTo(e2);
            }
            return frequency.get(e2) - frequency.get(e1);
        });

        return uniqueWords.subList(0, k);
    }
}