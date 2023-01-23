class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] arr = new int[n + 1];
        for (int[] tst: trust) {
            arr[tst[0]] ++;
            arr[tst[1]] --;
        }

        for (int i = 1; i < arr.length; i ++) {
            if (arr[i] == (-1) * (n - 1)) {
                return i;
            }
        }
        return -1;
    }
}
