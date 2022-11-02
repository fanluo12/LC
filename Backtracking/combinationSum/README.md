```
class Solution {
    public List<List<Integer>> combinationSum2(int[] A, int target) {
        Arrays.sort(A);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(A, target, res, new ArrayList<>(), 0);
        return res;
    }
    
    public void backtrack(int[] A, int target, List<List<Integer>> res, List<Integer> path, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        else if (target < 0) {
            return;
        }
        
        for (int i = start; i < A.length; i ++) {
            if (A[i] > target || (i > start && A[i] == A[i - 1])) {
                continue;
            }
            path.add(A[i]);
            backtrack(A, target - A[i], res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
```
