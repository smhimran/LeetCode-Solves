class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty()) {
                char c = stack.peek();
                if (isSimilar(c, s.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        String res = "";
        Iterator<Character> it = stack.iterator();

        while (it.hasNext()) {
            res += it.next().toString();
        }

        return res;
    }

    private boolean isSimilar(char a, char b) {
        return (((a + 32 ) == b) || ((b + 32) == a));
    }
}