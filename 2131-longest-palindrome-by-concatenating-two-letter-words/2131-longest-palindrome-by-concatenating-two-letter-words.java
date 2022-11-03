class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> frequency = new HashMap<>();
        int lengthOfLongestPalindrome = 0;
        int singlePalindrome = 0;

        for (String word: words) {
            String reverse = new StringBuilder(word).reverse().toString();
            boolean isSinglePalindrome = false;

            if (reverse.equals(word)) {
                isSinglePalindrome = true;
            }

            if (frequency.getOrDefault(reverse, 0) != 0) {
                lengthOfLongestPalindrome += 4;
                frequency.put(reverse, frequency.get(reverse) - 1);

                if (isSinglePalindrome) {
                    singlePalindrome--;
                }
            } else {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);

                if (isSinglePalindrome) {
                    singlePalindrome++;
                }
            }
        }

        if (singlePalindrome > 0) {
            lengthOfLongestPalindrome += 2;
        }

        return lengthOfLongestPalindrome;
    }
}