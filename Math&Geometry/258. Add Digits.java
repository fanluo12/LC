class Solution1 {
    public int addDigits(int num) {
        int res = 0;
        if (num < 10) {
            return num;
        }
        while (num >= 10) {
            res = (num % 10) + (num / 10);
            num = res;
        }
        return res;
    }
}

class Solution2 {
    public int addDigits(int num) {
        //0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,.....
        //0,1,2,3,4,5,6,7,8,9,1, 2, 3, 4, 5, 6, 7,......
        return num == 0 ? 0 : (num - 1) % 9 + 1;
    }
}
