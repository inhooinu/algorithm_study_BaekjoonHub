import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashMap<Integer, Integer> pocketmon = new HashMap<>();  // 종류, 수
        for (int i=0; i<nums.length; i++) {
            int type = nums[i];
            pocketmon.put(type, pocketmon.getOrDefault(type, 0)+1);
        }
        System.out.println(pocketmon);
        
        int cnt = nums.length/2;
        if (pocketmon.size()>cnt) return cnt;
        return pocketmon.size();
    }
}