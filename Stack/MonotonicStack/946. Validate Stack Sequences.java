class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int indexPop = 0;
        
        for (int p: pushed) {
            stack.push(p);
            while (!stack.empty() && stack.peek() == popped[indexPop]) {
                indexPop ++;
                stack.pop();
            }
        }
        return stack.empty();
    }
}
