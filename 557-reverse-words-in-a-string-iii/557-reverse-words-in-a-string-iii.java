class Solution {
    public String reverseWords(String s) {
        String ret = ""; 
        
        for (String word: s.split(" ")) {
            if (ret.length() > 0) {
                ret += " ";
            }
            
            ret += new StringBuilder(word).reverse().toString();
        }
        
        return ret;
    }   
}