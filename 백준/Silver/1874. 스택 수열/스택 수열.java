import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static Deque<Integer> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		stack = new ArrayDeque<>();
		
		int n = Integer.parseInt(br.readLine());
		int num = 1;
		
		for (int i=0; i<n; i++) {
			int target = Integer.parseInt(br.readLine());
			
			while (num<=target) {
				stack.push(num++);
				sb.append("+\n");
			}
			
			if (stack.peek()==target) {
				stack.pop();
				sb.append("-\n");
			} else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(sb);
	}
}
