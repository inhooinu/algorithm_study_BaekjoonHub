import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<int[]> bridge = new ArrayDeque<>();
        int totalWeight = 0;  // 다리 위에 있는 트럭의 총 무게
        int cnt = 0;  // 다리 위에 있는 트럭의 수
        int pass = 0;  // 다리를 지나간 트럭의 수
        int idx = 0;  // 다음에 올라갈 트럭의 인덱스
        int time = 0;
        
        while (true) {
            
            for (int[] truck: bridge) {
                truck[0]++;
            }
            
            if (!bridge.isEmpty() && bridge.peek()[0]>=bridge_length) {
                int[] cur = bridge.poll();
                pass++;
                totalWeight -= cur[1];
                cnt--;
            }
            
            // 다리 위에 올라갈 수 있으면 진입
            if (idx<truck_weights.length 
                && bridge_length>=cnt+1 && weight>=totalWeight+truck_weights[idx]) {
                bridge.offer(new int[] {0, truck_weights[idx]});
                totalWeight += truck_weights[idx];
                cnt++;
                idx++;
            }
            
            time++;
            // System.out.print(time+": ");
            // for (int[] truck: bridge) {
            //     System.out.print(truck[1]+" ");
            // }
            // System.out.println();
            
            // 다리를 지나간 트럭의 수가 총 트럭의 개수와 같아지면 종료
            if (pass==truck_weights.length) break;
        }
        
        return time;
    }
}