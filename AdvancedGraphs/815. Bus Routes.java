class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int busStop = 0; busStop < routes.length; busStop ++) {
            for (int stop : routes[busStop]) {
                if (!map.containsKey(stop)) {
                    map.put(stop, new HashSet<Integer>());
                }
                map.get(stop).add(busStop);
            }
        }
        
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{source, 0});
        // use boolean array to mark visited bus stops
        boolean[] seen = new boolean[routes.length];
        // hashset visited to add buses
        Set<Integer> visited = new HashSet<>();
        
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int stop = tmp[0], busNumber = tmp[1];
            if (stop == target) {
                return busNumber;
            }
            for (int busStop: map.get(stop)) {
                if (seen[busStop]) {
                    continue;
                }
                for (int bus: routes[busStop]) {
                    if (!visited.contains(bus)) {
                        visited.add(bus);
                        queue.offer(new int[]{bus, busNumber + 1});
                    }
                }
                seen[busStop] = true;
            }
        }
        return -1;
    }
}
