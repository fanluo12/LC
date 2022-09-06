class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        if (target < 0) {
            return;
        }
        
        for (int i = start; i < candidates.length; i ++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            backtrack(res, path, candidates, i + 1, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
