import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] stringNumbers = new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(stringNumbers, (a,b) -> (b+a).compareTo(a+b));
        // System.out.println(Arrays.toString(stringNumbers));
        
        if (stringNumbers[0].equals("0")) return "0";
        
        String answer = "";
        for (int i=0; i<stringNumbers.length; i++) {
            answer += stringNumbers[i];
        }
        
        return answer;
    }
}