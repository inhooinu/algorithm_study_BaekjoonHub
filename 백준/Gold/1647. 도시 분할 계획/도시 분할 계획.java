import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static ArrayList<Edge>[] graph;
	static class Edge implements Comparable<Edge> {
		int v, w;  // 정점, 가중치
		Edge(int v, int w) {
			this.v=v; this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static int maxCost = 0;
	static int costSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Edge(b,c));
			graph[b].add(new Edge(a,c));
		}
		
		// MST 구하기
		prim();
//		System.out.println(maxCost);
//		System.out.println(costSum);
		System.out.println(costSum-maxCost);
	}

	private static void prim() {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (visited[cur.v]) continue;
			visited[cur.v] = true;
			costSum += cur.w;
			maxCost = Math.max(maxCost, cur.w);
			
			for (Edge next: graph[cur.v]) {
				if (visited[next.v]) continue;
				pq.offer(new Edge(next.v, next.w));
			}
		}
	}
}
