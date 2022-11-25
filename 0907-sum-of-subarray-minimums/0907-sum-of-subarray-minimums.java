class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        int mod = 1000000007;

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                left.put(i, 0);
                continue;
            }

            int numbersGreaterInLeft = 0;
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                numbersGreaterInLeft += left.get(stack.pop());
                numbersGreaterInLeft++;
            }

            left.put(i, numbersGreaterInLeft);
            stack.push(i);
        }

        stack.clear();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
                right.put(i, 0);
                continue;
            }

            int numbersGreaterInRight = 0;
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                numbersGreaterInRight += right.get(stack.pop());
                numbersGreaterInRight++;
            }

            right.put(i, numbersGreaterInRight);
            stack.push(i);
        }

        long result = 0;

        for (int i = 0; i < arr.length; i++) {
            long now = (left.get(i) * right.get(i));
            now += (left.get(i) + right.get(i));
            now++;

            if (now >= mod) {
                now %= mod;
            }

            result += now * arr[i];

            if (result >= mod) {
                result %= mod;
            }
        }

        return (int) result;
    }
}