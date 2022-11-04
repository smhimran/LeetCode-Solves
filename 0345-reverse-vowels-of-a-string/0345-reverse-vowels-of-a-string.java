class Solution {
    public String reverseVowels(String s) {
        StringBuilder word = new StringBuilder(s);
        int left = 0, right = s.length() - 1;
        boolean leftFound = false, rightFound = false;

        while (left < right) {
            if (isVowel(s.charAt(left)))  {
                leftFound = true;
            }

            if (isVowel(s.charAt(right))) {
                rightFound = true;
            }

            if (leftFound && rightFound) {
                word.setCharAt(left, s.charAt(right));
                word.setCharAt(right, s.charAt(left));

                leftFound = false;
                rightFound = false;
            }

            if (!leftFound) {
                left++;
            }

            if (!rightFound) {
                right--;
            }
        }

        return word.toString();
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U');
    }
}