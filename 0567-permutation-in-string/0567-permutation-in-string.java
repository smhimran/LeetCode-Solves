class Solution {
    private final Map<Character, Integer> frequencyInS1 = new HashMap<>();
    private final Map<Character, Integer> frequencyInS2 = new HashMap<>();

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int left = 0;
        int right = 0;

        while (right < s1.length()) {
            frequencyInS1.put(s1.charAt(right), frequencyInS1.getOrDefault(s1.charAt(right), 0) + 1);
            frequencyInS2.put(s2.charAt(right), frequencyInS2.getOrDefault(s2.charAt(right), 0) + 1);
            right++;
        }
        
        if (isEqualFrequency()) {
            return true;
        }

        while (right < s2.length()) {
            frequencyInS2.put(s2.charAt(left), frequencyInS2.get(s2.charAt(left)) - 1);
            frequencyInS2.put(s2.charAt(right), frequencyInS2.getOrDefault(s2.charAt(right), 0) + 1);

            left++;
            right++;

            if (isEqualFrequency()) {
                return true;
            }
        }

        return false;
    }

    private boolean isEqualFrequency() {
        for (char i = 'a'; i <= 'z'; i++) {
            if (!frequencyInS1.getOrDefault(i, 0).equals(frequencyInS2.getOrDefault(i, 0))) {
                return false;
            }
        }
        return true;
    }
}