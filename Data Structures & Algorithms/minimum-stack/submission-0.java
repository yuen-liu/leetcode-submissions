class MinStack {
    /**
    initialize the stack object
    */
    ArrayList<Integer> stack = new ArrayList<>();
    int min = Integer.MAX_VALUE;

    public MinStack() {
    }
    
    public void push(int val) {
        // update min
        if (stack.isEmpty() || val < min) {
            min = val;
        }
        stack.add(val);   
    }
    
    public void pop() {
        stack.remove(stack.size() - 1);
    
        // recalculate min
        if (stack.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = Integer.MAX_VALUE;
            for (int num : stack) {
                min = Math.min(num, min);
            }
        }
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return min;
    }
}
