class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        for (String deadend: deadends) {
            set.add(deadend);
        }
        if (set.contains(target)) {
            return -1;
        }
        HashSet<String> visited = new HashSet<>();
        Deque<String> lock = new LinkedList<>();
        Deque<Integer> turns = new LinkedList<>();
        lock.offer("0000");
        turns.offer(0);
        
        while (!lock.isEmpty() && !turns.isEmpty()) {
            String tmpLock = lock.poll();
            int tmpTurn = turns.poll();
            if (tmpLock.equals(target)) {
                return tmpTurn;
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
                    turns.offer(tmpTurn + 1);
                }
                
                if (!visited.contains(s2)) {
                    visited.add(s2);
                    lock.offer(s2);
                    turns.offer(tmpTurn + 1);
                }
            }
        }
        return -1;
    }
}
