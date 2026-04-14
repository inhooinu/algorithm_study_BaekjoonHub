import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] indeg;
	static int[] time;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		indeg = new int[N+1];
		time = new int[N+1];
		result = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			
			while (true) {
				int num = Integer.parseInt(st.nextToken());
				if (num==-1) break;
				graph[num].add(i);
				indeg[i]++;
			}
		}
		
//		System.out.println(Arrays.toString(indeg));
//		System.out.println(Arrays.toString(time));
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i=1; i<=N; i++) {
			result[i] = time[i];
			if (indeg[i]==0) q.offer(i);
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next: graph[cur]) {
				indeg[next]--;
				result[next] = Math.max(result[next], result[cur]+time[next]);
				if (indeg[next]==0) q.offer(next);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb);
	}
}
