import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 가중치가 있는 그래프에서 최소비용 구하기
public class Main {
	
	static int N, M, X;  // N명의 학생(=N개의 마을), M개의 단방향 도로, X번 마을
	static ArrayList<Edge>[] graph;
	static ArrayList<Edge>[] reverseGraph;
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
	static int[] costFromX;
	static int[] costToX;
	static int maxVal = Integer.MAX_VALUE/2;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		reverseGraph = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
		// 그래프 입력 받기
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			graph[s].add(new Edge(e,t));
			reverseGraph[e].add(new Edge(s,t));
		}
		costFromX = new int[N+1];
		costToX = new int[N+1];
		// 비용 배열 max 값으로 초기화
		for (int i=1; i<=N; i++) {
			costFromX[i] = maxVal;
			costToX[i] = maxVal;
		}
		
		// graph에서 최소 비용 탐색
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		costFromX[X] = 0;
		pq.add(new Edge(X,0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (Edge next: graph[cur.v]) {
				if (costFromX[next.v] > costFromX[cur.v] + next.w) {
					costFromX[next.v] = costFromX[cur.v] + next.w;
					pq.offer(new Edge(next.v,costFromX[next.v]));
				}
			}
		}
//		System.out.println(Arrays.toString(costFromX));
		
		// reverseGraph에서 최소 비용 탐색
		pq = new PriorityQueue<>();
		costToX[X] = 0;
		pq.add(new Edge(X,0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (Edge next: reverseGraph[cur.v]) {
				if (costToX[next.v] > costToX[cur.v] + next.w) {
					costToX[next.v] = costToX[cur.v] + next.w;
					pq.offer(new Edge(next.v,costToX[next.v]));
				}
			}
		}
//		System.out.println(Arrays.toString(costToX));
		
		for (int i=1; i<=N; i++) {
			int totalCost = costFromX[i] + costToX[i];
			result = Math.max(result, totalCost);
		}
		System.out.println(result);
	}

}
