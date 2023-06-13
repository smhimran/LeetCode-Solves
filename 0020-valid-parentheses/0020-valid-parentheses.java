class Solution {
    public boolean isValid(String s) {
        boolean valid = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpening(c)) {
                stack.push(c);
            } else {
                if (!stack.empty() && getOpposite(c) == stack.peek()) {
                    stack.pop();
                } else {
                    valid = false;
                    break;
                }
            }
        }

        if (!stack.empty()) {
            valid = false;
        }

        return valid;
    }

    private boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private char getOpposite(char c) {
        switch (c) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return '*';
        }
    }
}