class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, res = 0, right = 0;
        
        while (right < fruits.length) {
            map.put(fruits[right], right);
            if (map.size() > 2) {
                int minIndex = Collections.min(map.values());
                map.remove(fruits[minIndex]);
                left = minIndex + 1;
            }
            res = Math.max(res, right - left + 1);
            right ++;
        }
        return res;
    }
}
