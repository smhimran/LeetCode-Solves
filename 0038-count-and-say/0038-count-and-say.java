class Solution {
    private String[] result = new String[31];

    public Solution() {
        preCalculate();
    }

    public String countAndSay(int n) {
        return result[n];
    }

    private void preCalculate() {
        result[0] = "0";
        result[1] = "1";

        for (int i = 2; i <= 30; i++) {
            char previous;
            int count = 1;
            String now = "";
            String lastWord = result[i - 1];

            previous = lastWord.charAt(0);

            for (int j = 1; j < lastWord.length(); j++) {
                if (lastWord.charAt(j) == previous) {
                    count++;
                } else {
                    now += (String.valueOf(count) + String.valueOf(previous));
                    previous = lastWord.charAt(j);
                    count = 1;
                }
            }

            now += (String.valueOf(count) + String.valueOf(previous));

            result[i] = now;
        }
    }
}