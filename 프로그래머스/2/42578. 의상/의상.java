import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] c: clothes) {
            String key = c[1];
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        // System.out.println(map);
        
        int answer = 1;
        for (String key: map.keySet()) {
            // System.out.println(key);
            answer *= (map.get(key)+1);
        }
        answer = answer-1;
        
        return answer;
    }
}