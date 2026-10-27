class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // brute force soln: o(n^2) runtime where we use two for loops
        // iterate through the array and find indices where temp[j] > temp[i]

        // o(n) runtime and o(n) spacetime soln: use a stack
        Stack<int[]> stack = new Stack<>(); // [temp, index] 
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i]; // two cases
            // t is greater than stack.peek() in which case we update res
            // or t is less than stack.peek() and we push it to the stack
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                // update res: difference between i and pair[0]
                res[pair[1]] = i - pair[1];
            }
            
            int[] pair = new int[2];
            pair[0] = t;
            pair[1] = i;
            stack.push(pair);
        }

        return res;
    }
}
