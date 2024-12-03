class Solution {
public:
    string addSpaces(string s, vector<int>& spaces) {
        int spaceIndex = 0;
        string word = "";
        string result = "";

        int nextSpace = spaces[spaceIndex++];

        for (int i = 0; i < s.length(); i++) {
            if (i == nextSpace) {
                result += word;
                result += " ";
                word = "";
                if (spaceIndex < spaces.size())
                    nextSpace = spaces[spaceIndex++];
            }

            word += s[i];
        }

        result += word;

        return result;
    }
};