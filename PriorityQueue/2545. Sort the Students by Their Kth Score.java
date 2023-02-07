class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[k] - a[k]));
        for (int[] s: score) {
            pq.offer(s);
        }
        int index = 0;
        while (!pq.isEmpty()) {
            score[index] = pq.poll();
            index ++;
        }
        return score;
    }
}
