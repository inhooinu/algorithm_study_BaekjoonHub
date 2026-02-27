import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;  // 컴퓨터의 수
	static int M;  // 선의 수
	static class Edge implements Comparable<Edge> {
		int v, weight;
		Edge(int v, int weight) {
			this.v=v; this.weight=weight;
		}
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
	}
	static List<Edge>[] adj;
	static boolean[] visited;
	static long min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(b, c));
			adj[b].add(new Edge(a, c));
		}
		System.out.println(prim());
	}

	private static long prim() {
		min = 0L;
		int cnt=0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1,0));
		
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (visited[edge.v]) continue;
			min += edge.weight;
			visited[edge.v]=true;
			
			if (++cnt==N) return min;
			for (int i=0; i<adj[edge.v].size(); i++) {
				Edge next = adj[edge.v].get(i);
				if(visited[next.v]) continue;
				pq.offer(next);
			}
		}
		
		return min;
	}
}
