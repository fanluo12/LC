class Solution {
    public int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int size = 1;
        while (true) {
            for (int i = 1; i <= n; i ++) {
                for (int x: new ArrayList<>(set)) {
                    if (x % i == 1) {
                        set.add(i);
                    }
                }
            }
            if (size == set.size()) {
                break;
            }
            size = set.size();
        }
        return size;
    }
}
