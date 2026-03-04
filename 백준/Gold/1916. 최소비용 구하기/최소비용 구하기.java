import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;  // N개의 도시, M개의 버스
	static ArrayList<Edge>[] graph;
	static class Edge implements Comparable<Edge> {
		int v, w;
		Edge(int v, int w) {
			this.v=v; this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static int targetS, targetE;
	static int[] dist;
	static boolean[] visited;
	static PriorityQueue<Edge> pq;
	static int maxVal = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s, e, cost;
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			graph[s].add(new Edge(e,cost));
		}
		st = new StringTokenizer(br.readLine());
		targetS = Integer.parseInt(st.nextToken());
		targetE = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		visited = new boolean[N+1];
		pq = new PriorityQueue<>();
		
		// 최소 비용 탐색
		Arrays.fill(dist, maxVal);
		dist[targetS] = 0;
		pq.offer(new Edge(targetS, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.v]) continue;
			visited[cur.v] = true;
			for (Edge next: graph[cur.v]) {
				if (dist[next.v] > dist[cur.v] + next.w) {
					dist[next.v] = dist[cur.v] + next.w;
					pq.offer(new Edge(next.v, dist[next.v]));
				}
			}
		}
//		System.out.println(Arrays.toString(dist));
//		System.out.println(Arrays.toString(visited));
		System.out.println(dist[targetE]);
	}
}
