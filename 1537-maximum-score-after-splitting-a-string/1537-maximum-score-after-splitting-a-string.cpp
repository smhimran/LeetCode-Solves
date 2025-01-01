class Solution {
public:
    int maxScore(string s) {
        if (s == "00") {
            return 1;
        }

        if (s == "01") {
            return 2;
        }

        if (s == "10") {
            return 0;
        }

        if (s == "11") {
            return 1;
        }

        int n = s.length();

        int zeroes[n];
        int ones[n];

        int zeroesSoFar = 0;
        int onesSoFar = 0;

        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                zeroesSoFar++;
            }
            zeroes[i] = zeroesSoFar; 
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == '1') {
                onesSoFar++;
            }
            ones[i] = onesSoFar;
        }

        int maximumScore = 1;

        for (int i = 1; i < n - 1; i++) {
            maximumScore = max(maximumScore, zeroes[i] + ones[i]);
        }

        return maximumScore;
    }
};