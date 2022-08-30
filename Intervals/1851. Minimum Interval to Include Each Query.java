class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int[] Q = queries.clone();
        Arrays.sort(queries);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        
        int i = 0;
        // i is used to record index
        for (int q: queries) {
            while (i < intervals.length && q >= intervals[i][0]) {
                pq.offer(new int[]{intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i ++;
            }
            while (!pq.isEmpty() && q > pq.peek()[1]) {
                pq.poll();
            }
            map.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
        }
        
        int[] res = new int[queries.length];
        i = 0;
        for (int q: Q) {
            res[i ++] = map.get(q);
        }
        return res;
    }
}
