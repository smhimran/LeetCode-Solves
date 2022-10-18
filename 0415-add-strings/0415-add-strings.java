class Solution {
    public String addStrings(String num1, String num2) {
        String number1 = new StringBuilder(num1).reverse().toString();
        String number2 = new StringBuilder(num2).reverse().toString();
        String sum = "";
        int carry = 0;
        int i = 0, j = 0;
        
        while (i < number1.length() && j < number2.length()) {
            int val1 = number1.charAt(i) - '0';
            int val2 = number2.charAt(j) - '0';

            int sumNow = val1 + val2 + carry;
            sum += String.valueOf(sumNow % 10);
            carry = sumNow / 10;

            i++;
            j++;
        }

        while (i < number1.length()) {
            int val1 = number1.charAt(i) - '0';
            int sumNow = val1 + carry;
            sum += String.valueOf(sumNow % 10);
            carry = sumNow / 10;

            i++;
        }

        while (j < number2.length()) {
            int val2 = number2.charAt(j) - '0';
            int sumNow = val2 + carry;
            sum += String.valueOf(sumNow % 10);
            carry = sumNow / 10;

            j++;
        }

        if (carry > 0) {
            sum += String.valueOf(carry);
        }

        return new StringBuilder(sum).reverse().toString();
    }
}