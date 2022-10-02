class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int busStop = 0; busStop < routes.length; busStop ++) {
            for (int stop : routes[busStop]) {
                if (!map.containsKey(stop)) {
                    map.put(stop, new HashSet<Integer>());
                }
                map.get(stop).add(busStop);
            }
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{source, 0});
        HashSet<Integer> visited = new HashSet<>();
        boolean[] seen = new boolean[routes.length];
        
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int stop = tmp[0], busNumber = tmp[1];
            
            if (stop == target) {
                return busNumber;
            }
            
            for (int busStop : map.get(stop)) {
                if (seen[busStop]) {
                    continue;
                }
                for (int nextStop : routes[busStop]) {
                    if (!visited.contains(nextStop)) {
                        queue.offer(new int[]{nextStop, busNumber + 1});
                        visited.add(nextStop);
                    }
                }
                seen[busStop] = true;
            }
        }
        return -1;
    }
}
