class Solution {

    Map<Integer, List<Integer>> map;
    Random rand;

    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        rand = new Random();
        int res = 0;
        List<Integer> indices = map.get(target);
        int index = rand.nextInt(indices.size());
        res = indices.get(index);
        return res;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
