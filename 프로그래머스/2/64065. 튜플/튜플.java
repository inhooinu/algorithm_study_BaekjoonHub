import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<String> answerList = new ArrayList<>();
        
        String temp = s.substring(2, s.length()-2);
        String[] arr = temp.split("\\},\\{");
        
        Arrays.sort(arr, (a,b)->Integer.compare(a.length(), b.length()));
        for (int i=0; i<arr.length; i++) {
            // System.out.println(arr[i]);
            
            // 목표: 새로 생긴 숫자를 answerList에 add 하기
            
            // 1. arr[i]를 , 기준으로 split
            String[] nums = arr[i].split(",");
            
            // 2. nums 배열을 돌면서 answer에 해당 원소가 있는지 확인, 없으면 answerList에 add
            for (int j=0; j<nums.length; j++) {
                if (!answerList.contains(nums[j])) {
                    answerList.add(nums[j]);
                    break;
                }
            }
        }
        System.out.println(answerList);
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = Integer.parseInt(answerList.get(i));
        }
        
        return answer;
    }
}