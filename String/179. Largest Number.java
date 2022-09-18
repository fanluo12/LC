class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] a = new String[n];
        
        for (int i = 0; i < n; i ++) {
            a[i] = String.valueOf(nums[i]);
        }
        
        for (int i = 0; i < n - 1; i ++) {
            for (int j = i + 1; j < n; j ++) {
                if (Long.parseLong(a[i] + a[j]) <= Long.parseLong(a[j] + a[i])) {
                    String tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
        
        String res = String.join("", a);
        return res.charAt(0) == '0' ? "0" : res;
    }
}
