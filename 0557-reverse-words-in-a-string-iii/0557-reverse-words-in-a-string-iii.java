class Solution {
    public String reverseWords(String s) {
        return Stream.of(s.split(" ")).map(word -> new StringBuilder(word).reverse())
            .collect(Collectors.joining(" "));
    }
}