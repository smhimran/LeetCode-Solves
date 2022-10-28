class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();

        for (String word: strs) {
            String sortedWord = word.chars()
                                        .sorted()
                                        .collect(StringBuilder::new, 
                                                    StringBuilder::appendCodePoint, 
                                                    StringBuilder::append)
                                        .toString();

            if (!group.containsKey(sortedWord)) {
                group.put(sortedWord, new ArrayList<>());
            }

            group.get(sortedWord).add(word);
        }

        return new ArrayList<>(group.values());
    }
}