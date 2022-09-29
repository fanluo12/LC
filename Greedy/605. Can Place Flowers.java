class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // expand flowerbed with extra head and tail place
        int[] expandbed = new int[flowerbed.length + 2];
        for (int i = 0; i < flowerbed.length; i ++) {
            expandbed[i + 1] = flowerbed[i];
        }
        
        for (int i = 1; i < expandbed.length - 1; i ++) {
            if (expandbed[i - 1] == 0 && expandbed[i] == 0 && expandbed[i + 1] == 0) {
                expandbed[i] = 1;
                n --;
            }
        }
        return n <= 0;
    }
}
