Another find sum question, we need to SORT array first then backtrack. In backtrack method, we update target - A[i] until target == 0. The difference between two questions is that question 40 asks no duplicate and each value must used once
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
            if (A[i] > target) {
                continue;
            }
            // for question 40, we need to add duplicate check
            /**
            if (A[i] > target || (i > start && A[i] == A[i - 1])) {
                continue;
            }
            */
            path.add(A[i]);
            backtrack(A, target - A[i], res, path, i);
            // for question 40, since each element can be used once, we need to backtrack from next position
            // backtrack(A, target - A[i], res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
```
