import java.io.*;
import java.util.*;

public class Main {
	static int V, E, K;
	static List<int[]>[] graph;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] {v, w});
		}
		
		dijkstra(K);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dijkstra(int start) {
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
			
		});
		dist[start] = 0;
		pq.offer(new int[] {start, 0});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if(cur[1] != dist[cur[0]]) continue;
			
			for (int[] next : graph[cur[0]]) {
				int nextDist = cur[1] + next[1];
				if(nextDist < dist[next[0]]) {
					dist[next[0]] = nextDist;
					pq.offer(new int[] {next[0], nextDist});
				}
			}
		}
	}
}
