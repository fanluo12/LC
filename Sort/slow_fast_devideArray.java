class Solution2 {
    public int[] tandemSort(int[] arr) {
        int slow = 0, fast = 0;
        while (fast + 1 < arr.length && fast + 2 < arr.length) {
            slow ++;
            fast += 2;
        }
        Deque<Integer> big = new LinkedList<>();
        Deque<Integer> small = new LinkedList<>();
        int right = arr.length - 1, left = 0;
        while (left <= slow) {
            small.offer(arr[left]);
            left ++;
        }
        while (right > slow) {
            big.offer(arr[right]);
            right --;
        }
        int[] res = new int[arr.length];
        int index = 0;
        boolean flag = true;
        System.out.println(small);
        while (!big.isEmpty() && !small.isEmpty()) {
            if (flag) {
                res[index] = big.poll();
                flag = false;
            }
            else {
                res[index] = small.poll();
                flag = true;
            }
            index ++;
        }
        if (small.size() == 1) { // even
            res[res.length - 1] = small.poll();
        }
        else if (small.size() == 2) { // odd
            res[res.length - 2] = small.poll();
            res[res.length - 1] = small.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        Solution2 solution2 = new Solution2();
        int[] res = solution2.tandemSort(arr);
        for (int i: res) {
            System.out.println(i);
        }
    }
}
