class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i ++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < i + 1; j ++) {
                if (j == 0 || j == i) {
                    res.get(i).add(1);
                }
                else {
                    res.get(i).add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
        }
        return res.get(rowIndex);
    }
}
