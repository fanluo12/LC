class Solution {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        
        for (int i = 0; i < ratings.length - 1; i ++) {
            if (ratings[i + 1] > ratings[i]) {
                res[i + 1] = res[i] + 1;
            }
        }
        
        for (int i = ratings.length - 1; i >= 1; i --) {
            if (ratings[i - 1] > ratings[i]) {
                res[i - 1] = Math.max(res[i - 1], 1 + res[i]);
            } 
        }
        
        int sum = 0;
        for (int i: res) {
            sum += i;
        }
        return sum;
    }
}
