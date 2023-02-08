class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target)) {
            return 0;
        }
        int n = words.length;
        String[] big = new String[n * 3];
        for (int i = 0; i < 3 * n; i ++) {
            if (i >= n) {
                big[i] = words[i % n]; 
            }
            else {
                big[i] = words[i];
            }
        }
        
        startIndex = n + startIndex;
        int left = startIndex, right = startIndex;
        int leftCount = 0, rightCount = 0;
        while (left > 0) {
            if (big[left].equals(target)) {
                break;
            }
            left --;
            leftCount ++;
        }

        while (right < 3 * n - 1) {
            if (big[right].equals(target)) {
                break;
            }
            right ++; 
            rightCount ++;
        }

        if (left == 0 && right == 3 * n - 1 && !big[left].equals(target) && !big[right].equals(target)) {
            return -1;
        }
        return Math.min(leftCount, rightCount);
    }
}
