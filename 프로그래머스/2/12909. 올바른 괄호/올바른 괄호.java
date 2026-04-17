import java.util.*;

class Solution {
    
    static ArrayDeque<Character> stack;
    
    boolean solution(String s) {
        boolean answer = true;

        stack = new ArrayDeque<>();
        
        // 입력으로 주어지는 문자 (, )
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='(') {  // (가 입력으로 들어오면
                // stack에 넣기
                stack.push('(');
            } else {  // )가 입력으로 들어오면
                // 비어있다면 answer = false
                // 그렇지 않다면 pop
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        
        // stack에 남아있는 것이 있다면 answer = false
        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}