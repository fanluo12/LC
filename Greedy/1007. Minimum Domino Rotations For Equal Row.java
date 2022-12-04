class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] T = new int[7];
        int[] B = new int[7];
        int[] intersect = new int[7];
        
        for (int i = 0; i < tops.length; i ++) {
            T[tops[i]] ++;
            B[bottoms[i]] ++;
            if (tops[i] == bottoms[i]) {
                intersect[tops[i]] ++;
            }
        }
        
        for (int i = 0; i < 7; i ++) {
            if (T[i] + B[i] - intersect[i] == tops.length) {
                return Math.min(T[i], B[i]) - intersect[i];
            }
        }
        return -1;
    }
}
