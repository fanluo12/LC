class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int a: asteroids) {
            while (!stack.empty() && stack.peek() > 0 && a < 0) {
                int diff = a + stack.peek();
                if (diff > 0) {
                    a = 0;
                }
                else if (diff < 0) {
                    stack.pop();
                }
                else {
                    a = 0;
                    stack.pop();
                }
            }
            if (a != 0) {
                stack.push(a);
            }
        }
        
        int[] res = new int[stack.size()];
        int index = 0;
        for (int a: stack) {
            res[index ++] = a;
        }
        return res;
    }
}
