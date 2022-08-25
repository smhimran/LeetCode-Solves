class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] frequency = new int[30];
        
        for (int i=0; i<magazine.length(); i++) {
            char c = magazine.charAt(i);
            frequency[(int) (c - 'a')]++;
        }
        
        boolean possible = true;
        
        for (int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int index = (int) (c - 'a');
            if (frequency[index] <= 0) {
                possible = false;
                break;
            }
            frequency[index]--;
        }
        
        return possible;
    }
}