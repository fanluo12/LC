class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int count: map.values()) {
            pq.offer(count);
        }
        
        int totalTime = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        while (!pq.isEmpty() || !queue.isEmpty()) {
            totalTime ++;
            if (!pq.isEmpty()) {
                int count = pq.poll() - 1;
                if (count != 0) {
                    int[] arr = new int[]{count, totalTime + n};
                    queue.offer(arr);
                }
            }
            if (!queue.isEmpty() && queue.peek()[1] == totalTime) {
                pq.offer(queue.poll()[0]);
            }
        }
        return totalTime;
    }
}
