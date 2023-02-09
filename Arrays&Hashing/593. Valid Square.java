class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>(Arrays.asList(edgeLengh(p1, p2), edgeLengh(p1, p3), edgeLengh(p1, p4), edgeLengh(p2, p3), edgeLengh(p2, p4), edgeLengh(p3, p4)));
        return !set.contains(0) && set.size() == 2;

    }

    public int edgeLengh(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
