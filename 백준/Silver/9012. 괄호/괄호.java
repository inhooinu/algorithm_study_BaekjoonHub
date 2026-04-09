import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	static int T;
	static Deque<Character> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			stack = new ArrayDeque<>();
			
			String line = br.readLine();
			boolean isVPS = true;
			for (int i=0; i<line.length(); i++) {
				char c = line.charAt(i);
				if (c=='(') {
					stack.push(c);
				} else {
					if (stack.isEmpty()) {
						isVPS = false;
						break;
					} else if (stack.peek()=='(') {
						stack.pop();
					} else {
						isVPS = false;
						break;
					}
				}
			}
			if (!isVPS) {
				System.out.println("NO");
			} else if (!stack.isEmpty()) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
