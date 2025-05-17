import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;  // start is blocked
        if (target.equals("0000")) return 0;    // already at target
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer("0000");
        visited.add("0000");
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for (String next : getNextStates(curr)) {
                    if (dead.contains(next) || visited.contains(next)) continue;
                    if (next.equals(target)) return steps;
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        
        return -1; // no solution
    }
    
    // Generate all 8 possible states by turning each wheel up or down by 1
    private List<String> getNextStates(String s) {
        List<String> states = new ArrayList<>();
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < 4; i++) {
            char original = arr[i];
            
            // move wheel forward
            arr[i] = original == '9' ? '0' : (char)(original + 1);
            states.add(new String(arr));
            
            // move wheel backward
            arr[i] = original == '0' ? '9' : (char)(original - 1);
            states.add(new String(arr));
            
            // restore original for next iteration
            arr[i] = original;
        }
        
        return states;
    }
}
