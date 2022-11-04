class Solution {
 public:
    string reverseVowels(string s) {
        int left = 0, right = s.length() - 1;
        bool leftFound = false, rightFound = false;
        
        while (left < right) {
            if (isVowel(s[left]))  {
                leftFound = true;
            }

            if (isVowel(s[right])) {
                rightFound = true;
            }

            if (leftFound && rightFound) {
                swap(s[left], s[right]);
                
                leftFound = false;
                rightFound = false;
            }

            if (!leftFound) {
                left++;
            }

            if (!rightFound) {
                right--;
            }
        }

        return s;
    }
    
 private:
    bool isVowel(char c) {
        return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U');
    }
};