class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        int perimeter = 0;
        for (int m: matchsticks) {
            perimeter += m;
        }
        
        if (perimeter % 4 != 0) {
            return false;
        }
        
        int edge = perimeter / 4;
        int[] sides = new int[4];
        
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        return backtrack(matchsticks, 0, sides, edge);
    }
    
    public boolean backtrack(int[] matchsticks, int start, int[] sides, int edge) {
        if (start == matchsticks.length) {
            return true;
        }
        for (int i = 0; i < 4; i ++) {
            if (sides[i] + matchsticks[start] <= edge) {
                sides[i] += matchsticks[start];
                if (backtrack(matchsticks, start + 1, sides, edge)) {
                    return true;
                }
                sides[i] -= matchsticks[start];
            }
        }
        return false;
    }
    
    public void reverse(int[] matchsticks) {
        int left = 0, right = matchsticks.length - 1;
        while (left < right) {
            int tmp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = tmp;
            left ++;
            right --;
        }
    }
}
