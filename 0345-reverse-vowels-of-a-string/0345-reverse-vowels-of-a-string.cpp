class Solution {
public:
    string reverseVowels(string s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (isVowel(s[left]) and isVowel(s[right])) {
                swap(s[left], s[right]);
                left++;
                right--;
            }
            
            while (left < s.length() and !isVowel(s[left])) {
                left++;
            }
            
            while (right > -1 and !isVowel(s[right])) {
                right--;
            }
        }

        return s;
    }

    bool isVowel(char c) {
        switch (c) {
            case 'a':
                return true;
            case 'A':
                return true;
            case 'e':
                return true;
            case 'E':
                return true;
            case 'i':
                return true;
            case 'I':
                return true;
            case 'o':
                return true;
            case 'O':
                return true;
            case 'u':
                return true;
            case 'U':
                return true;
            default:
                return false;
        }
    }
};