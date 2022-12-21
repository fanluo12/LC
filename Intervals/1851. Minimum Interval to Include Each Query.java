class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] originalQueries = queries.clone();

        Arrays.sort(queries);
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        int index = 0;
        for (int q: queries) {
            while (index < intervals.length && q >= intervals[index][0]) {
                pq.offer(new int[]{intervals[index][1] - intervals[index][0] + 1, intervals[index][1]});
                index ++;
            }
            while (!pq.isEmpty() && q > pq.peek()[1]) {
                pq.poll();
            }
            map.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
        }

        int[] res = new int[originalQueries.length];
        for (int i = 0; i < originalQueries.length; i ++) {
            res[i] = map.get(originalQueries[i]);
        }
        return res;
    }
}
