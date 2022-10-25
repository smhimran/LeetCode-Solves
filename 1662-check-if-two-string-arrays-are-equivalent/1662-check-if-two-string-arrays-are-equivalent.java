class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String sentence1 = String.join("", word1);
        String sentence2 = String.join("", word2);

        if (sentence1.equals(sentence2)) {
            return true;
        }

        return false;
    }
}