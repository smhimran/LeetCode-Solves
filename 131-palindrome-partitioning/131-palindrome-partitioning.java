class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        fun(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void fun(String s, int i, List<String> part, List<List<String>> result) {
        if (i == s.length()) {
            result.add(new ArrayList<>(part));
            return;
        }
        
        for (int j=i; j<s.length(); j++) {
            String now = s.substring(i, j + 1);
            if (isPalindrome(now)) {
                part.add(now);
                fun(s, j + 1, part, result);
                part.remove(part.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}