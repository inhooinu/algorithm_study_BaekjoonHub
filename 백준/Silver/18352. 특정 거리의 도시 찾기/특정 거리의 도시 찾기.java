import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int v, w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		
		
	}
	static int N, M, K, X;
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	static int[] dist;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Integer> ans = new ArrayList<>(); 
	public static void main(String[] args) throws IOException {
		init();
		dji();
		for(int i=1; i<=N; i++) {
			if(dist[i] == K) {
				ans.add(i);
			}
		}
		if(ans.isEmpty()) {
			System.out.println(-1);
		}else {
			for(int n: ans) {
				System.out.println(n);
			}
		}
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		for(int i = 0; i<=N; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i =0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj.get(v).add(w);
		}
	}
	
	static void dji() {
		PriorityQueue<Edge> heap = new PriorityQueue<>();
		heap.offer(new Edge(X, 0));
		
		while(!heap.isEmpty()) {
			Edge cur = heap.poll();
			if(dist[cur.v] < cur.w) continue;
			for(int next: adj.get(cur.v)) {
				if(dist[next] <= dist[cur.v] + 1) continue;
				dist[next] = dist[cur.v] + 1;
				heap.offer(new Edge(next, dist[next]));
			}
		}
	}
	


}
