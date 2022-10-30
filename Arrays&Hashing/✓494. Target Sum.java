class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int n: nums) {
            Map<Integer, Integer> subMap = new HashMap<>();
            for (int sum: map.keySet()) {
                subMap.put(sum - n, subMap.getOrDefault(sum - n, 0) + map.get(sum));
                subMap.put(sum + n, subMap.getOrDefault(sum + n, 0) + map.get(sum));
            }
            map = subMap;
        }
        return map.get(target) == null ? 0 : map.get(target);
    }
}
