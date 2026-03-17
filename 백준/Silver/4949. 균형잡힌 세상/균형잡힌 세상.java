import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = br.readLine();
			if (line.equals(".")) break;
			
			List<Character> stack = new ArrayList<>();
			boolean result = true;
			for (int i=0; i<line.length(); i++) {
				char c = line.charAt(i);
				if (c=='(' || c=='[') {
					stack.add(c);
				} else if (c==')' || c==']') {
					if (stack.isEmpty()) {
						System.out.println("no");
						result = false;
						break;
					}
					
					if (c==')') {
						char last = stack.get(stack.size()-1);
						if (last=='(') {
							stack.remove(stack.size()-1);
						} else {
							System.out.println("no");
							result = false;
							break;
						}
					} else if (c==']') {
						char last = stack.get(stack.size()-1);
						if (last=='[') {
							stack.remove(stack.size()-1);
						} else {
							System.out.println("no");
							result = false;
							break;
						}
					}	
				}
			}
			
			if (result && stack.isEmpty()) System.out.println("yes");
			else if (result) System.out.println("no");
		}
	}
}
