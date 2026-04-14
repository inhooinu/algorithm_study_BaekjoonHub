import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static HashSet<String> heard;
	static HashSet<String> seen;
	static HashSet<String> result;
	static ArrayList<String> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		heard = new HashSet<>();
		seen = new HashSet<>();
		for (int i=0; i<N; i++) {
			String name = br.readLine();
			heard.add(name);
		}
		for (int i=0; i<M; i++) {
			String name = br.readLine();
			seen.add(name);
		}
		
		result = new HashSet<>(heard);
		result.retainAll(seen);
		
		list = new ArrayList<>(result);
		System.out.println(list.size());
		Collections.sort(list);
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
