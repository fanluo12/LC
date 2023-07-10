class Solution {
    public int[] sortByBits(int[] originalArr) {
        Integer[] arr = new Integer[originalArr.length];
        for (int i = 0; i < originalArr.length; i ++) {
            arr[i] = originalArr[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int countA = countBits(a);
            int countB = countBits(b);

            if (countA == countB) {
                return a - b;
            }
            else {
                return countA - countB;
            }
        });

        for (int i = 0; i < originalArr.length; i ++) {
            originalArr[i] = arr[i];
        }
        return originalArr;
    }

    public int countBits(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        while (n > 0) {
            int remainder = n % 2;
            if (remainder == 1) {
                count ++;
            }
            n /= 2;
        }

        return count;
    }
}
