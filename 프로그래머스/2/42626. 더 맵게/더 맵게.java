import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> foods = new PriorityQueue<>();
        for (int i=0; i<scoville.length; i++) {
            foods.offer(scoville[i]);
        }
        // System.out.println(foods);
        
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        int cnt = 0;
        while (foods.size()>=2) {
            int food1 = foods.poll();  // 가장 맵지 않은 음식의 스코빌 지수
            int food2 = foods.poll();  // 두 번째로 맵지 않은 음식의 스코빌 지수
            if (food1>=K) break;
            
            int newFood = food1 + food2*2;
            foods.offer(newFood);
            cnt++;
        }
        if (!foods.isEmpty() && foods.peek()<K) {
            return -1;
        }

        return cnt;
    }
}