class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> digit = new ArrayList<>();
        for (int number: nums) {
            Stack<Integer> stack = separate(number);
            while (!stack.isEmpty()) {
                digit.add(stack.pop());
            }
        }
        
        int[] res = new int[digit.size()];
        for (int i = 0; i < digit.size(); i ++) {
            res[i] = digit.get(i);
        }
        return res;
    }

    public Stack<Integer> separate(int number) {
        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            stack.push(number % 10);
            number /= 10;
        }
        return stack;
    }
}
