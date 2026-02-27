import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 스패닝 트리 구하기
// 최소 스패닝 트리: 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리
public class Main {
	
	static int V, E;
	static class Edge implements Comparable<Edge> {
		int v;
		int weight;
		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight,  e.weight);
		}
	}
	static List<Edge>[] adj;
	static long min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[V+1];
		for (int i=0; i<V+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Edge(e,w));
			adj[e].add(new Edge(s,w));
		}
		System.out.println(prim());
	}

	private static long prim() {
		long min=0L;
		boolean[] visited=new boolean[V+1];
		PriorityQueue<Edge> points=new PriorityQueue<>();
		points.offer(new Edge(1,0));
		int cnt=0;
		while (!points.isEmpty()) {
			Edge edge=points.poll();
			if (visited[edge.v]) continue;
			min+=edge.weight;
			visited[edge.v]=true;
			if(++cnt==V) return min;
			for (int i=0; i<adj[edge.v].size(); i++) {
				Edge next=adj[edge.v].get(i);
				if (visited[next.v]) continue;
				points.offer(next);
			}
		}
		return min;
	}
}
