class Solution {
    public int maximum69Number (int num) {
        StringBuilder numString = new StringBuilder("" + num);

        for (int i = 0; i < numString.length(); i++) {
            if (numString.charAt(i) == '6') {
                numString.setCharAt(i, '9');
                break;
            }
        }

        return Integer.valueOf(numString.toString());
    }
}