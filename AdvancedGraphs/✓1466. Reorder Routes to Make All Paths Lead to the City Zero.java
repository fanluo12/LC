class Solution {
    
    int res = 0;
    
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int[] cities: connections) {
            map.putIfAbsent(cities[0], new ArrayList<>());
            map.putIfAbsent(cities[1], new ArrayList<>());
            map.get(cities[0]).add(new int[]{cities[1], 1});
            map.get(cities[1]).add(new int[]{cities[0], 0});
        }
        
        HashSet<Integer> visited = new HashSet<>();
        dfs(0, map, visited);
        return res;
    }
    
    public void dfs(int city, HashMap<Integer, List<int[]>> map, HashSet<Integer> visited) {
        visited.add(city);
        for (int i = 0; i < map.get(city).size(); i ++) {
            if (!visited.contains(map.get(city).get(i)[0])) {
                visited.add(map.get(city).get(i)[0]);
                res += map.get(city).get(i)[1];
                dfs(map.get(city).get(i)[0], map, visited);
            }
        }
    }
}
