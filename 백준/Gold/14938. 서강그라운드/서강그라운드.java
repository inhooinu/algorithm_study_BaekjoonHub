import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,r;
	static int[] item;
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
	static int[] dist;
	static int maxVal = Integer.MAX_VALUE/2;
	static int maxCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());  // 지역의 수
		m = Integer.parseInt(st.nextToken());  // 수색범위
		r = Integer.parseInt(st.nextToken());  // 길의 수
		item = new int[n+1];
		graph = new ArrayList[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			int t = Integer.parseInt(st.nextToken());
			item[i] = t;
		}
		
		for (int i=1; i<=n; i++) {  // graph 초기화
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());  // 길의 길이
			
			graph[a].add(new Edge(b,l));
			graph[b].add(new Edge(a,l));
		}
		
		for (int s=1; s<=n; s++) {  // s번째 지역에 떨어지는 경우에 대해 각각 얻을 수 있는 아이템의 개수 구하기
			dist = new int[n+1];
			for(int i=1; i<=n; i++) {  // dist 초기화
				dist[i] = maxVal;
			}
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			dist[s] = 0;  // 떨어진 지역은 거리가 0
			pq.offer(new Edge(s,0));
			while (!pq.isEmpty()) {
				Edge cur = pq.poll();
				for (Edge next: graph[cur.to]) {
					if (dist[next.to] > dist[cur.to] + next.w) {
						dist[next.to] = dist[cur.to] + next.w;
						pq.offer(new Edge(next.to, dist[next.to]));
					}
				}
			}
//			System.out.println(Arrays.toString(dist));
			
			int cnt = 0;
			for (int i=1; i<=n; i++) {
				if (dist[i] <= m) {  // 최단경로의 거리가 수색 범위보다 작으면
					cnt += item[i];
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
	}
}
