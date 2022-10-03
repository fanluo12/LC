class Solution {
    public boolean stoneGame(int[] piles) {
        int left = 0, right = piles.length - 1;
        boolean aliceTurn = true;
        int alice = 0, bob = 0;
        
        while (left <= right) {
            if (aliceTurn) {
                if (piles[left] < piles[right]) {
                    alice += piles[right];
                    right --;
                }
                else {
                    alice += piles[left];
                    left ++;
                }
                aliceTurn = false;
            }
            else {
               if (piles[left] < piles[right]) {
                    bob += piles[left];
                    left ++;
                }
                else {
                    bob += piles[right];
                    right --;
                }
                aliceTurn = true; 
            }
        }
        return alice > bob;
    }
}
