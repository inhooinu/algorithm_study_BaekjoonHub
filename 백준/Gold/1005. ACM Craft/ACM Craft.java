import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int T;
	static int N, K;  // 건물의 개수, 건물간의 건설순서 규칙
	static int[] time;
	static int[] totalTime;
	static ArrayList<Integer>[] graph;
	static int[] indeg;
	static int W;  // 걸설해야 할 건물의 번호
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = new int[N+1];
			totalTime = new int[N+1];
			graph = new ArrayList[N+1];
			for (int i=1; i<=N; i++) {
				graph[i] = new ArrayList<>();
			}
			indeg = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				totalTime[i] = time[i];
			}
			
			for (int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				graph[X].add(Y);
				indeg[Y]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new ArrayDeque<>();
			for (int i=1; i<=N; i++) {
				if (indeg[i]==0) {
					q.offer(i);
				}
			}
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				
				for (int next: graph[cur]) {
					indeg[next]--;
					totalTime[next] = Math.max(totalTime[next], totalTime[cur] + time[next]);
					
					if (indeg[next]==0) {
						q.offer(next);
					}
				}
			}
			
			System.out.println(totalTime[W]);
		}
	}
}
