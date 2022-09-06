class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, new int[nums.length]);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i ++) {
            if (visited[i] == 1) {
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
