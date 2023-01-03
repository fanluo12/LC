class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0, count = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int n: nums) {
            prefixSum += n;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
