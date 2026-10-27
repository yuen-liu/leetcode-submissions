class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                if (stack.size() < 2) {
                    return 0; // or throw an exception for invalid input
                }
                int a = stack.pop();
                int b = stack.pop();
                if (token.equals("+")) stack.push(a + b);
                if (token.equals("-")) stack.push(b - a);
                if (token.equals("*")) stack.push(a * b);
                if (token.equals("/")) stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.isEmpty() ? 0 : stack.pop();
    }
}