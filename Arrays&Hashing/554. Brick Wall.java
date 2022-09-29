class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0); // prevent case [[1],[1],[1]]
        for (int i = 0; i < wall.size(); i ++) {
            int total = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j ++) {
                total += wall.get(i).get(j);
                map.put(total, map.getOrDefault(total, 0) + 1);
            }
        }
        
        int max = Collections.max(map.values());
        return wall.size() - max;
    }
}
