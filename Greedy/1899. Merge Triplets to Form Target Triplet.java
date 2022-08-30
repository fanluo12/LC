class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int a = 0, b = 0, c = 0;
        
        for (int[] triplet: triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                a = Math.max(triplet[0], a);
                b = Math.max(triplet[1], b);
                c = Math.max(triplet[2], c);
            }
        }
        return a == target[0] && b == target[1] && c == target[2];
    }
}
