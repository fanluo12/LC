class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int n: nums) {
            HashMap<Integer, Integer> subMap = new HashMap<>();
            for (int sum: map.keySet()) {
                subMap.put(sum - n, subMap.getOrDefault(sum - n, 0) + map.get(sum));
                subMap.put(sum + n, subMap.getOrDefault(sum + n, 0) + map.get(sum));
            }
            map = subMap;
        }
        return map.getOrDefault(target, 0);
    }
}
