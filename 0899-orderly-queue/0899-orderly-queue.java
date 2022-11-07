class Solution {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            return Stream.of(s.split(""))
                        .sorted()
                        .collect(Collectors.joining());
        } else {
            StringBuilder word = new StringBuilder(s);
            String minimumString = s;
            
            for (int i = 0; i < s.length(); i++) {
                char c = word.charAt(0);
                word.deleteCharAt(0);
                word.append(c);
                
                if (minimumString.compareTo(word.toString()) > 0) {
                    minimumString = word.toString();
                }
            }
            
            return minimumString;
        }
    }
}
