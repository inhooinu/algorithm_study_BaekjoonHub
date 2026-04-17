import java.util.*;

class Solution
{
    static ArrayDeque<Character> stack = new ArrayDeque<>();
    
    public int solution(String s)
    {
        for (int i=0; i<s.length(); i++) {
            char alpha = s.charAt(i);
            
            if (stack.isEmpty()) {
                stack.push(alpha);
            } else {
                if (stack.peek()==alpha) {
                    stack.pop();
                } else {
                    stack.push(alpha);
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}