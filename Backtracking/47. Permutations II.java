class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, new int[nums.length]);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i ++) {
            if (visited[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = 1;
            backtrack(res, path, nums, visited);
            visited[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
