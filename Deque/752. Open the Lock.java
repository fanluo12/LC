class Solution {
    public int openLock(String[] deadends, String target) {
        // use set to store deadends
        Set<String> set = new HashSet<>();
        for (String deadend: deadends) {
            set.add(deadend);
        }
        // if target is a deadend then return -1
        if (set.contains(target)) {
            return -1;
        }
        // use visited set to record happened situations
        Set<String> visited = new HashSet<>();
        // use 2 queues to record lock and steps
        Deque<String> lock = new LinkedList<>();
        Deque<Integer> steps = new LinkedList<>();
        // initiate 2 queues
        lock.offer("0000");
        steps.offer(0);
        
        while (!lock.isEmpty() && !steps.isEmpty()) {
            String tmpLock = lock.poll();
            int step = steps.poll();
            if (tmpLock.equals(target)) {
                return step;
            }
            else if (set.contains(tmpLock)) {
                continue;
            }
            
            for (int i = 0; i < 4; i ++) {
                char curDigit = tmpLock.charAt(i);
                int digitUp = (curDigit == '9' ? 0 : curDigit - '0' + 1);
                int digitDown = (curDigit == '0' ? 9 : curDigit - '0' - 1);
                String s1 = tmpLock.substring(0, i) + digitUp + tmpLock.substring(i + 1);
                String s2 = tmpLock.substring(0, i) + digitDown + tmpLock.substring(i + 1);
                if (!visited.contains(s1)) {
                    visited.add(s1);
                    lock.offer(s1);
                    steps.offer(step + 1);
                }
                
                if (!visited.contains(s2)) {
                    visited.add(s2);
                    lock.offer(s2);
                    steps.offer(step + 1);
                }
            }
        }
        return -1;
    }
}
