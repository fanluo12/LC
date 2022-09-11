class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }
        
        for (int n: set) {
            if (!set.contains(n - 1)) {
                int start = n;
                while (set.contains(start)) {
                    start ++;
                }
                res = Math.max(res, start - n);
            }
        }
        return res;
    }
}
