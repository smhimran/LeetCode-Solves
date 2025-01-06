class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int[] left = new int[n];
        int[] right = new int[n];
        int[] answer = new int[n];

        int ballsToTheLeft = 0;
        int ballsToTheRight = 0;

        if (boxes.charAt(0) == '1') {
            ballsToTheLeft++;
        }

        if (boxes.charAt(n - 1) == '1') {
            ballsToTheRight++;
        }

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1];
            left[i] += ballsToTheLeft;

            if (boxes.charAt(i) == '1') {
                ballsToTheLeft++;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1];
            right[i] += ballsToTheRight;

            if (boxes.charAt(i) == '1') {
                ballsToTheRight++;
            }
        }

        for (int i = 0; i < n; i++) {
            answer[i] = left[i] + right[i];
        }

        return answer;
    }
}