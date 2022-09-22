class Solution {
    public String reverseWords(String s) {
        String ret = ""; 
        
        for (String word: s.split(" ")) {            
            ret += new StringBuilder(word).reverse().toString() + " ";
        }
        
        return ret.trim();
    }   
}