import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            int num = arr[i];
            if (answerList.isEmpty() || answerList.get(answerList.size()-1)!=num) {
                answerList.add(num);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}