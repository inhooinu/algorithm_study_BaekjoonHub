import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// A번째 도시에서 B번째 도시까지 가는데 드는 최소비용과 경로 구하기
public class Main {
	
	static int n, m;  // n개의 도시, m개의 버스
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
	static int startPoint, endPoint;
	static int[] dist;
	static int maxVal = Integer.MAX_VALUE/2;
	static int[] prev;
	static ArrayList<Integer> path;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		for (int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[s].add(new Edge(e,cost));
		}
		st = new StringTokenizer(br.readLine());
		startPoint = Integer.parseInt(st.nextToken());
		endPoint = Integer.parseInt(st.nextToken());  // 입력받기 완료
		
		dist = new int[n+1];
		// dist 초기화
		for (int i=1; i<=n; i++) {
			dist[i] = maxVal;
		}
		prev = new int[n+1];
		path = new ArrayList<>();
		
		dist[startPoint] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(startPoint,0));  // 시작점
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (cur.w > dist[cur.to]) continue;
			
			for (Edge next: graph[cur.to]) {
				if (dist[next.to] > dist[cur.to] + next.w) {
					dist[next.to] = dist[cur.to] + next.w;
					prev[next.to] = cur.to;  // next는 cur에서 옴
					pq.offer(new Edge(next.to, dist[next.to]));
				}
			}
		}
		
		for (int i=endPoint; i!=startPoint; i=prev[i]) {
			path.add(i);
		}
		path.add(startPoint);
		
//		System.out.println(Arrays.toString(prev));
		System.out.println(dist[endPoint]);
		System.out.println(path.size());
		Collections.reverse(path);
		for (int x: path) {
			System.out.print(x+" ");
		}
	}
}
