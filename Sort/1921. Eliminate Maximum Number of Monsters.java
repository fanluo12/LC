class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        // convert dist to time-to-target array
        for (int i = 0; i < dist.length; i ++) {
            dist[i] = (int)Math.ceil((double)dist[i] / speed[i]);
        }
        
        Arrays.sort(dist);
        for (int i = 0; i < dist.length; i ++) {
            if (i >= dist[i]) { // cumulated current time is greater than monster to target, ie monster already reaches target
                return i;
            }
        }
        return dist.length;
    }
}
