import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i=0; i<prices.length; i++) {
            int curPrice = prices[i];
            int time = 0;
            for (int j=i+1; j<prices.length; j++) {
                time++;
                if (curPrice>prices[j]) break;
            }
            answerList.add(time);
        }
        // System.out.println(answerList);
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}