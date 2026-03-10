import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;  // 강의동의 수, 공사구간의 수
	static long K;
	static boolean[] blocked;
	static class Edge implements Comparable<Edge> {
		int s,e,w;
		public Edge(int s, int e, int w) {
			this.s=s; this.e=e; this.w=w;
		}
		public int compareTo(Edge edge) {
			return Integer.compare(this.w, edge.w);
		}
	}
	static int[] parents;
	static int[] size;
	static String result = "YES";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		if (M <= 1) {
		    System.out.println("YES");
		    return;
		}
		
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int n=1; n<=N; n++) {
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(0,n,w));
		}
		
		blocked = new boolean[N+1];
		for (int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			if (i>j) {
				int temp = i;
				i = j;
				j = temp;
			}
			
			if (i==1 && j==N) blocked[N] = true;
			else blocked[i] = true;
		}
		
		for (int s=1; s<=N; s++) {
			int e = (s==N) ? 1: s+1;
			if (!blocked[s]) {
				pq.offer(new Edge(s,e,0));
			}
		}
		
		parents = new int[N+1];
		size = new int[N+1];
		
		makeSet();
		int cnt = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (union(edge.s, edge.e)) {
//				System.out.println(edge.s+" "+edge.e+" "+K);
				if (K < edge.w) {
					result = "NO";
					break;
				}
				
				K -= edge.w;
				cnt++;
				if (cnt==N) break;
			}
		}
		
		int group = 0;
		for (int i=0; i<=N; i++) {
			if (parents[i]==i) group++;
		}
		if (group!=1) result = "NO";
		System.out.println(result);
	}

	private static boolean union(int s, int e) {
		int sRoot = findSet(s);
		int eRoot = findSet(e);
		
		if (sRoot == eRoot) return false;
		
		if (size[sRoot] < size[eRoot]) {
			size[eRoot] += size[sRoot];
			parents[sRoot] = eRoot;
		} else {
			size[sRoot] += size[eRoot];
			parents[eRoot] = sRoot;
		}
		return true;
	}

	private static int findSet(int s) {
		if (parents[s]==s) return parents[s];
		return parents[s] = findSet(parents[s]);
	}

	private static void makeSet() {
		for (int i=0; i<=N; i++) {
			parents[i] = i;
			size[i] = 1;
		}
	}
}
