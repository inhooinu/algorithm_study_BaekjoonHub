import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int K;
	static int V, E;
	static ArrayList<Integer>[] graph;
	static String result;
	static int[] color;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=K; t++) {
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			graph = new ArrayList[V+1];
			for (int i=1; i<=V; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
			}
			result = "YES";
			color = new int[V+1];
			
			for (int i=1; i<=V; i++) {
				if (color[i]==0) {
					bfs(i);
					if (result.equals("NO")) break;
				}
			}

			System.out.println(result);
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		
		color[start] = 1;
		q.offer(start);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next: graph[cur]) {
				if (color[next]==0) {  // 처음 색을 칠함
					color[next] = -color[cur];
					q.offer(next);
				} else {
					if (color[next]==color[cur]) {
						result = "NO";
						return;
					}
				}
			}
		}
	}
}
