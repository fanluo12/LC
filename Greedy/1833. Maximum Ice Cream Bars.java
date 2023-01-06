class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        if (coins < costs[0]) {
            return 0;
        }
        
        int count = 0;
        for (int bar: costs) {
            coins -= bar;
            if (coins < 0) {
                break;
            }
            count ++;
        }
        return count;
    }
}
