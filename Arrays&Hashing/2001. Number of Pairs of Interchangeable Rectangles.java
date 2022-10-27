class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();
        for (int[] r: rectangles) {
            double k = Math.atan2(Double.valueOf(r[0]), Double.valueOf(r[1]));
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        long res = 0;
        // NOTE here to transfer integer to double
        for (double c: map.values()) {
            if (c > 1) {
                res += c * (c - 1) / 2;
            }
        }
        return res;
    }
}

class Solution2 {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> map = new HashMap<>();
        
        for (int[] rec: rectangles) {
            double k = Math.atan2((double)rec[0], (double)rec[1]);
            map.put(k, map.getOrDefault(k, (long)0) + 1);
        }
        
        long res = 0;
        for (long k: map.values()) {
            if (k > 1) {
                res += k * (k - 1) / 2;
            }
        }
        return res;
    }
}
