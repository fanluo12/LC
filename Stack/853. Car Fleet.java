class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) {
            return 1;
        }
        
        int[][] zipPositionSpeed = new int[position.length][2];
        for (int i = 0; i < position.length; i ++) {
            zipPositionSpeed[i][0] = position[i];
            zipPositionSpeed[i][1] = speed[i];
        }
        
        Arrays.sort(zipPositionSpeed, (a, b) -> (b[0] - a[0]));
        
        Stack<Double> stack = new Stack<>();
        
        for (int i = 0; i < position.length; i ++) {
            double curTime = (double)(target - zipPositionSpeed[i][0]) / zipPositionSpeed[i][1];
            // if upcoming time is 
            if (!stack.empty() && stack.peek() >= curTime) {
                continue;
            }
            else {
                stack.push(curTime);
            }
        }
        return stack.size();
    }
}
