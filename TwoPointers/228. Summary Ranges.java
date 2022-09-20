class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        
        if (nums.length == 0 || nums.length == 0) {
            return res;
        }
        
        int end = 0;
        while (end < nums.length) {
            int start = end;
            while (end < nums.length - 1 && nums[end + 1] == nums[end] + 1) {
                end ++;
            }
            if (start == end) {
                res.add(String.valueOf(nums[end]));
            }
            else {
                res.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]));
            }
            end ++;
        }
        return res;
    }
}
