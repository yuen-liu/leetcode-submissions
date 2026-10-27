class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // two possibilities: c is either an operator or operand
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                if (stack.size() < 2) return 0;
                int a = stack.pop();
                int b = stack.pop();
                char c = token.charAt(0);
                if (c == '+') stack.push(a + b);
                if (c == '-') stack.push(b - a);
                if (c == '*') stack.push(a * b);
                if (c == '/') stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        if (stack.isEmpty()) return 0;
        else return stack.pop();
    }
}
