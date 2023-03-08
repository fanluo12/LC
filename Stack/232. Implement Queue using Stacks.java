class MyQueue {

    Stack<Integer> mainStack;
    Stack<Integer> helperStack;
    public MyQueue() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
    }
    
    public void push(int x) {
        mainStack.push(x);
        
    }
    
    public int pop() {
        while (!mainStack.isEmpty()) {
            helperStack.push(mainStack.pop());
        }
        int res = helperStack.pop();
        while (!helperStack.isEmpty()) {
            mainStack.push(helperStack.pop());
        }
        return res;
    }
    
    public int peek() {
        while (!mainStack.isEmpty()) {
            helperStack.push(mainStack.pop());
        }
        int res = helperStack.peek();
        while (!helperStack.isEmpty()) {
            mainStack.push(helperStack.pop());
        }
        return res;
    }
    
    public boolean empty() {
        return mainStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
