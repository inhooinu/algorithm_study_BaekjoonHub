import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int[] priorityCnt = new int[10];
        
        ArrayDeque<int[]> q = new ArrayDeque<>();  // idx, priority
        for (int i=0; i<priorities.length; i++) {
            q.add(new int[] {i, priorities[i]});
            priorityCnt[priorities[i]]++;
        }
        System.out.println(Arrays.toString(priorityCnt));
        
        int p = findMaxPriority(priorityCnt);
        int answer = 0;
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            if (cur[1]<p) q.offerLast(cur);
            else {
                // System.out.println(cur[0]+" "+cur[1]);
                answer++;

                if (cur[0]==location) {
                    break;
                }
                
                priorityCnt[cur[1]]--;
                if (priorityCnt[cur[1]]==0) {
                    p = findMaxPriority(priorityCnt);
                }
            }
        }
        
        
        return answer;
    }
    
    public int findMaxPriority(int[] priorityCnt) {
        for (int i=9; i>0; i--) {
            if (priorityCnt[i]>0) return i;
        }
        
        return 0;
    }
}