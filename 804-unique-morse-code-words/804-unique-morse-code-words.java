class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Map<String, Boolean> taken = new HashMap<>();
        
        for (String word: words) {
            String morseWord = "";
            for (int i=0; i<word.length(); i++) {
                int index = (int) (word.charAt(i) - 'a');
                morseWord += morse[index];
            }
            taken.put(morseWord, true);
        }
        
        return taken.keySet().size();
    }
}