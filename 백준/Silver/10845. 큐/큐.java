import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static Deque<Integer> q;
	
	public static void main(String[] args) {
		q = new ArrayDeque<>();
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			String command = sc.next();
			if (command.equals("push")) {
				int x = sc.nextInt();
				q.offer(x);
			} else if (command.equals("pop")) {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.poll()).append("\n");
				}
			} else if (command.equals("size")) {
				sb.append(q.size()).append("\n");
			} else if (command.equals("empty")) {
				if (q.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (command.equals("front")) {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.peekFirst()).append("\n");
				}
			} else if (command.equals("back")) {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(q.peekLast()).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
