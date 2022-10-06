class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i ++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        Arrays.sort(jobs, (a, b) -> (a[1] - b[1]));
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, 0);
        
        for (int[] job: jobs) {
            int curProfit = tm.floorEntry(job[0]).getValue() + job[2];
            if (curProfit > tm.lastEntry().getValue()) {
                tm.put(job[1], curProfit);
            }
        }
        return tm.lastEntry().getValue();
    }
}
