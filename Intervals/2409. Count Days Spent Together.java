class Solution {
    public static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] A = new int[]{convertDateToArray(arriveAlice), convertDateToArray(leaveAlice)};
        int[] B = new int[]{convertDateToArray(arriveBob), convertDateToArray(leaveBob)};
        if (A[1] < B[0] || B[1] < A[0]) {
            return 0;
        }
        int start = Math.max(A[0], B[0]);
        int end = Math.min(A[1], B[1]);
        return end - start + 1;
        
    }

    public int convertDateToArray(String date) {
        int monthIndex = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3));
        int month = 0;
        for (int i = 0; i < monthIndex - 1; i ++) {
            month += days[i];
        }
        return month + day;

    }
}
