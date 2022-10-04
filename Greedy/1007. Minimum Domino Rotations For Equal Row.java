class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countTop = new int[7];
        int[] countBottom = new int[7];
        int[] union = new int[7];
        
        for (int i = 0; i < tops.length; i ++) {
            countTop[tops[i]] ++;
            countBottom[bottoms[i]] ++;
            if (tops[i] == bottoms[i]) {
                union[tops[i]] ++;
            }
        }
        
        for (int i = 0; i <= 6; i ++) {
            if (countTop[i] + countBottom[i] - union[i] == tops.length) {
                return Math.min(countTop[i], countBottom[i]) - union[i];
            }
        }
        return -1;
    }
}
