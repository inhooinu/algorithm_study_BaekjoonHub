import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] indeg;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		indeg = new int[N+1];
		result = new int[N+1];
		
		for (int i=0; i<M ;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			indeg[b]++;
		}  // 입력 끝
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i=1; i<=N; i++) {
			if (indeg[i]==0) {
				q.offer(i);
				result[i] = 1;
			}
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next: graph[cur]) {
				indeg[next]--;
				if (indeg[next]==0) {
					q.offer(next);
					result[next] = result[cur]+1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; i++) {
			sb.append(result[i]+" ");
		}
		System.out.println(sb);
	}
}
