class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        for (int r = 0; r < ROWS; r ++) {
            for (int c = 0; c < COLS; c ++) {
                pq.offer(-matrix[r][c]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return -pq.poll();
    }
}
