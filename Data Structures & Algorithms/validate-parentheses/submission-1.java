class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        // iterate through the string
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) { // if it's a closing bracket
                if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                    stack.pop(); // we have a valid set
                } else {
                    return false; // set is not valid
                }
            } else { // if it's an opening bracket
                stack.push(c);
            }
        }
        return (stack.isEmpty());
    }
}
