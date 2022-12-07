class Solution {
    public boolean halvesAreAlike(String s) {
        int[] vowels = new int[2];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                if (i < n / 2) {
                    vowels[0]++;
                } else {
                    vowels[1]++;
                }
            }
        }

        return vowels[0] == vowels[1];
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        
        return false;
    }
}