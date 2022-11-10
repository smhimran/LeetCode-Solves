class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        Iterator<Character> it = stack.iterator();
        String ret = "";

        while (it.hasNext()) {
            ret += "" + it.next();
        }

        return ret;
    }
}