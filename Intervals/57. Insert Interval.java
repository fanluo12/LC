class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        
        for (int i = 0; i < intervals.length; i ++) {
            if (intervals[i][0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = intervals[i];
            }
            else if (newInterval[0] <= intervals[i][1]) {
                newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])};
            }
            else {
                res.add(intervals[i]);
            }
        }
        
        res.add(newInterval);
        return res.toArray(new int[res.size()][2]);
    }
}
