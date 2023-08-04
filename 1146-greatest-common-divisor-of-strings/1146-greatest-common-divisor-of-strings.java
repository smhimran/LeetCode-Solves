class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int gcdOfLengths = gcd(str1.length(), str2.length());
        int left = 0;
        int right = gcdOfLengths;

        String gcdString = str1.substring(left, right);

        if (isStringAMultipleOfGCD(str1, gcdString) && isStringAMultipleOfGCD(str2, gcdString)) {
            return gcdString;
        } 

        return "";
    }

    private boolean isStringAMultipleOfGCD(String str, String gcd) {
        boolean isMultiple = true;
        int left = 0;
        int right = gcd.length();

        while (right <= str.length()) {
            String currentSubstring = str.substring(left, right);

            if (!currentSubstring.equals(gcd)) {
                isMultiple = false;
                break;
            }

            left = right;
            right += gcd.length();
        }

        return isMultiple;
    }

    private int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}