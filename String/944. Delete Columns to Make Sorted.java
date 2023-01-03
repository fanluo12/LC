class Solution {
    public int minDeletionSize(String[] strs) {
        if (strs.length == 1) {
            return 0;
        }
        /**
        c b a
        d a f
        g h i
         */
         Set<Integer> visited = new HashSet<>();
         int count = 0;
        for (int i = 1; i < strs.length; i ++) {
            for (int j = 0; j < strs[i].length(); j ++) {
                if (strs[i].charAt(j) - strs[i - 1].charAt(j) < 0 && !visited.contains(j)) {
                    count ++;
                    visited.add(j);
                }
            }
        }
        return count;
    }
}
