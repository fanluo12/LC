// BFS solution
class Solution1 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i ++) {
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{headID, 0});
        
        int res = Integer.MIN_VALUE;
        
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int manageLevel = tmp[0], curTime = tmp[1];
            
            res = Math.max(res, curTime);
            if (map.containsKey(manageLevel)) {
                List<Integer> subordinates = map.get(manageLevel);
                for (int subordinate: subordinates) {
                    queue.offer(new int[]{subordinate, curTime + informTime[manageLevel]});
                }
            }
        }
        return res;
    }
}

// DFS solution
class Solution2 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < manager.length; i ++) {
            int j = manager[i];
            if (!graph.containsKey(j)) {
                graph.put(j, new ArrayList<>());
            }
            graph.get(j).add(i);
        }
        return dfs(graph, informTime, headID);
    }
    
    private int dfs(HashMap<Integer, List<Integer>> graph, int[] informTime, int head ) {
        int res = 0;
        if (!graph.containsKey(head))
            return res;
        for (int i = 0; i < graph.get(head).size(); i ++) {
            res = Math.max(res, dfs(graph, informTime, graph.get(head).get(i)) + informTime[head]);
        }
        return res;
    }
}
