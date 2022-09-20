class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer cand1 = null, cand2 = null;
        
        for (int n: nums) {
            if (cand1 != null && cand1 == n) {
                count1 ++;
            }
            else if (cand2 != null && cand2 == n) {
                count2 ++;
            }
            else if (cand1 == null || count1 == 0) {
                cand1 = n;
                count1 = 1;
            }
            else if (cand2 == null || count2 == 0) {
                cand2 = n;
                count2 = 1;
            }
            else {
                count1 --;
                count2 --;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == cand1) {
                count1 ++;
            }
            else if (n == cand2) {
                count2 ++;
            }
        }
        
        if (count1 > nums.length / 3) {
            res.add(cand1);
        }
        if (count2 > nums.length / 3) {
            res.add(cand2);
        }
        return res;
    }
}
