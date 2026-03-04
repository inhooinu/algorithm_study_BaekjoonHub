import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int V, E;  // 정점의 개수, 간선의 개수
	static int K;  // 시작정점의 번호
	static ArrayList<Edge>[] graph;
	static class Edge implements Comparable<Edge> {
		int v, w;
		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}		
	}
	static int[] dist;
	static boolean[] visited;
	static int maxVal = Integer.MAX_VALUE/10;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		graph = new ArrayList[V+1];
		for (int i=1; i<=V; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Edge(v, w));  // Edge(다음 정점, 간선 가중치)
		}
		dist = new int[V+1];
		for (int i=1; i<=V; i++) {
			dist[i] = maxVal;
		}
		dist[K] = 0;
		visited = new boolean[V+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();  // Edge(정점, 시작점에서의 누적거리)
		pq.offer(new Edge(K,0));  // 시작점
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.v]) continue;  // 이미 최단거리 확정
			visited[cur.v] = true;
			for (Edge next: graph[cur.v]) {
				if (dist[next.v] > dist[cur.v] + next.w) {
					dist[next.v] = dist[cur.v] + next.w;
					pq.offer(new Edge(next.v, dist[next.v]));
//					System.out.println(Arrays.toString(dist));
				}
			}
		}
		
		for (int i=1; i<=V; i++) {
			if (dist[i]==maxVal) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}
}