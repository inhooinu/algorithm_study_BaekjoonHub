import java.util.*;

class Solution {
    
    static class Process {
        int idx;
        int priority;
        public Process(int idx, int priority) {
            this.idx=idx;
            this.priority=priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        
        int maxPriority = 0;
        int[] priorityCnt = new int[10];
        for (int i=0; i<priorities.length; i++) {
            int priority = priorities[i];
            maxPriority = Math.max(maxPriority, priority);
            priorityCnt[priority]++;
        }
        
        Queue<Process> q = new ArrayDeque<>();
        for (int i=0; i<priorities.length; i++) {
            q.offer(new Process(i, priorities[i]));
        }
        
        int answer = 0;
        while (!q.isEmpty()) {
            Process cur = q.poll();
            
            if (cur.priority==maxPriority) {  // 실행
                answer++;
                
                priorityCnt[cur.priority]--;
                if (priorityCnt[cur.priority]==0) {
                    for (int i=cur.priority; i>0; i--) {
                        if (priorityCnt[i]>0) {
                            maxPriority=i;
                            break;
                        }
                    }
                }

                if (cur.idx==location) break;
            } else {  // 다시 넣기
                q.offer(cur);
            }
        }
        
        return answer;
    }
}