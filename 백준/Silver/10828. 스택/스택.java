import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    static Deque<Integer> stack;

    public static void main(String[] args) {
        stack = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            String command = sc.next();
            if (command.equals("push")) {
                int x = sc.nextInt();
                stack.push(x);
            } else if (command.equals("pop")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.pop());
            } else if (command.equals("size")) {
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                if (stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (command.equals("top")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());
            }
        }
    }
}
