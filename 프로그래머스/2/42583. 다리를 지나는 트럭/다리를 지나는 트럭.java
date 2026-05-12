import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i=0; i<truck_weights.length; i++) {
            q.offer(truck_weights[i]);
        }
        // System.out.println(q);
        
        int[] bridge = new int[bridge_length];
        int totalWeight = 0;
        int time = 0;
        while (true) {
            time++;
            
            if (totalWeight!=0) {
                totalWeight -= bridge[bridge.length-1];
                for (int i=bridge.length-1; i>0; i--) {
                    bridge[i] = bridge[i-1];
                }
                bridge[0] = 0;
            }
            
            if (!q.isEmpty() && totalWeight+q.peek() <= weight) {  // 다리 진입 가능하면
                int truck = q.poll();
                bridge[0] = truck;
                totalWeight += truck;
            }
            
            if (q.isEmpty() && totalWeight==0) break;  // 모두 다 통과한 경우 break
        }
        
        return time;
    }
}