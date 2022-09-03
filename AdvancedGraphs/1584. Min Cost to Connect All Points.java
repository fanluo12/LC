class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int res = 0;
        
        int[] distance = new int[n];
        
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        
        // start from 0 index, find shortest distance between 0 and i index
        for (int i = 1; i < n; i ++) {
            distance[i] = findDist(points, 0, i);
        }
        
        while (set.size() != n) {
            int next = -1;
            for (int i = 0; i < n; i ++) {
                if (set.contains(i)) {
                    continue;
                }
                // update next as shortest distance
                if (next == -1 || distance[next] > distance[i]) {
                    next = i;
                }
            }
            
            set.add(next);
            res += distance[next];
            // update all other non-visited points distance with next
            for (int i = 0; i < n; i ++) {
                if (!set.contains(i)) {
                    distance[i] = Math.min(distance[i], findDist(points, i, next));
                }
            }
        }
        return res;
    }
    
    public int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
}
