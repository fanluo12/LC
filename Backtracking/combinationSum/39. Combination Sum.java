class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (candidates[i] > target) {
                break;
            }
            else {
                path.add(candidates[i]);
                backtrack(res, path, candidates, i, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}
