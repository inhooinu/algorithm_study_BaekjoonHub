import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, E;
	static ArrayList<Edge>[] graph;
	static class Edge implements Comparable<Edge> {
		int to, w;
		public Edge(int to, int w) {
			this.to=to; this.w=w;
		}
		
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static int maxVal = Integer.MAX_VALUE/2;
	static int[] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b,c));
			graph[b].add(new Edge(a,c));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int d1 = calcMinDist(1,v1);
		int d2 = calcMinDist(v1,v2);
		int d3 = calcMinDist(v2, N);
		int d4 = calcMinDist(1,v2);
		int d5 = calcMinDist(v2,v1);
		int d6 = calcMinDist(v1, N);
		
		if (d1==maxVal || d2==maxVal || d3==maxVal || d4==maxVal || d5==maxVal || d6==maxVal) {
			System.out.println(-1);
		} else {
			// 1->v1->v2->N일 때의 최단 경로
			int dist1 = d1 + d2 + d3;
			// 1->v2->v1->N일 때의 최단 경로
			int dist2 = d4 + d5 + d6;
			
			System.out.println(Math.min(dist1, dist2));
		}
	}

	private static int calcMinDist(int from, int to) {
		dist = new int[N+1];
		for (int i=1; i<=N; i++) {
			dist[i] = maxVal;
		}
		
		dist[from] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(from,0));  // 시작점
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (cur.w > dist[cur.to]) continue;
			
			for (Edge next: graph[cur.to]) {
				if (dist[next.to] > dist[cur.to] + next.w) {
					dist[next.to] = dist[cur.to] + next.w;
					pq.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}
//		System.out.println(Arrays.toString(dist));
		return dist[to];
	}
}
