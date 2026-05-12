import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for (int c=0; c<commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];
            
            // array의 i번째부터 j번째까지 자르기
            ArrayList<Integer> list = new ArrayList<>();
            for (int idx=i-1; idx<j; idx++) {
                list.add(array[idx]);
            }
            
            // 오름차순 정렬
            Collections.sort(list);
            // System.out.println(list);
            
            answerList.add(list.get(k-1));
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}