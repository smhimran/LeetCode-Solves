class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[30];

        for (int i = 0; i < sentence.length(); i++) {
            int index = (int) (sentence.charAt(i)) - 97;
            freq[index]++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                return false;
            }
        }

        return true;
    }
}