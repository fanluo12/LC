class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        int[] degree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] e: edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            degree[e[0]] ++;
            degree[e[1]] ++;
        }
        
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                list.add(cur);
                for (int parent: map.get(cur)) {
                    degree[parent] --;
                    if (degree[parent] == 1) {
                        queue.offer(parent);
                    }
                }
            }
            res = list;
        }
        return res;
    }
}
