import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        int idx = 0;
        int[] p = progresses;
        
        while(idx<p.length) {
            
            for (int i=idx; i<p.length; i++) {
                p[i] += speeds[i];
            }
            
            // 100% 이상인 기능 찾기
            int cnt = 0;
            for (int i=idx; i<p.length; i++) {
                if (p[i]<100) break;                
                cnt++;
            }
            idx += cnt;
            if (cnt>0) {
                answerList.add(cnt);
                System.out.println(answerList);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}