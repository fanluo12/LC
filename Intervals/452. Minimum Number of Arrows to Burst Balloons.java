class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }

        int count = 0;
        int end = Integer.MIN_VALUE;
        // NOTE a[1] - b[1] will overflow for [[-2147483646,-2147483645],[2147483646,2147483647]], so we use Integer.compareTo
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        for (int[] point: points) {
            if (point[0] > end) {
                end = point[1];
                count ++;
            }
        }
        return count;
    }
}
