import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static HashSet<Integer> set;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		set = new HashSet<>();
		M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				set.add(x);
			} else if (command.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				set.remove(x);
			} else if (command.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				int result = set.contains(x) ? 1 : 0;
				sb.append(result).append("\n");
			} else if (command.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x)) set.remove(x);
				else set.add(x);
			} else if (command.equals("all")) {
				set.clear();
				for (int n=1; n<=20; n++) {
					set.add(n);
				}
			} else if (command.equals("empty")) {
				set.clear();
			}
		}
		
		System.out.println(sb);
	}
}
