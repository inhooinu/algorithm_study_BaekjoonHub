import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static HashSet<Integer> A;
	static HashSet<Integer> B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		A = new HashSet<>();
		B = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<a; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<b; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		HashSet<Integer> result1 = new HashSet<>(A);
		result1.removeAll(B);
		HashSet<Integer> result2 = new HashSet<>(B);
		result2.removeAll(A);
		
		System.out.println(result1.size()+result2.size());
	}
}
