class Solution {
    public int longestSquareStreak(int[] nums) {
        // sort array first
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;

        for (int number: nums) {
            int sqrt = (int)Math.sqrt(number);
            if (sqrt * sqrt == number && map.containsKey(sqrt)) {
                map.put(number, map.get(sqrt) + 1);
                res = Math.max(res, map.get(number));
            }
            else {
                map.put(number, 1);
            }
        }
        return res;
    }
}
