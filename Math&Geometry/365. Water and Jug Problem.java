class Solution {
    public boolean canMeasureWater(int a, int b, int c) {
        if (a + b < c) {
            return false;
        }
        
        if (a == c || b == c || a + b == c) {
            return true;
        }
        return c % gcd(a, b) == 0;
    }
    
    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
