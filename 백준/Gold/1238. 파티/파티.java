import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, X;  // N명의 학생(=N개의 마을), M개의 단방향 도로, 마을 X (목적지)
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
	static int[][] goCost;
	static int[] returnCost;
	static int[] totalCost;
	static PriorityQueue<Edge> pq;
	static int maxVal = Integer.MAX_VALUE/2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
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
		goCost = new int[N+1][N+1];
		returnCost = new int[N+1];
		totalCost = new int[N+1];
		for (int i=1; i<=N; i++) {
			Arrays.fill(goCost[i], maxVal);
		}
		Arrays.fill(returnCost, maxVal);
		
		// 갈 때 최소비용 탐색
		for (int i=1; i<=N; i++) {
			goCost[i][i] = 0;
		}
		for (int startNode=1; startNode<=N; startNode++) {  // 시작지점 1~N에 대하여
			pq = new PriorityQueue<>();
			pq.offer(new Edge(startNode, 0));
			while (!pq.isEmpty()) {
				Edge cur = pq.poll();
				for (Edge next: graph[cur.v]) {
					if (goCost[startNode][next.v] > goCost[startNode][cur.v] + next.w) {
						goCost[startNode][next.v] = goCost[startNode][cur.v] + next.w;
						pq.offer(new Edge(next.v, goCost[startNode][next.v]));
					}
				}
			}
		}
//		for (int i=1; i<=N; i++) {
//			System.out.println(Arrays.toString(goCost[i]));
//		}
//		System.out.println();
		
		// 올 때 최소비용 탐색
		returnCost[X] = 0;
		pq = new PriorityQueue<>();
		pq.offer(new Edge(X, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (Edge next: graph[cur.v]) {
				if (returnCost[next.v] > returnCost[cur.v] + next.w) {
					returnCost[next.v] = returnCost[cur.v] + next.w;
					pq.offer(new Edge(next.v, returnCost[next.v]));
				}
			}
		}
//		System.out.println(Arrays.toString(returnCost));
//		System.out.println();
		
		for (int i=1; i<=N; i++) {
			totalCost[i] = goCost[i][X] + returnCost[i];
		}
//		System.out.println(Arrays.toString(totalCost));
		
		int maxCost = 0;
		for (int i=1; i<=N; i++) {
			maxCost = Math.max(maxCost, totalCost[i]);
		}
		System.out.println(maxCost);
	}
}
