import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;  // 우주신들의 개수, 이미 연결된 신들과의 통로의 개수
	static double minLength;  // 새로 만들어야 할 정신적인 통로 길이들의 합의 최소
	static int[][] points;
	static class Edge implements Comparable<Edge> {
		int s,e;
		double w;
		public Edge(int s, int e, double w) {
			this.s=s; this.e=e; this.w=w;
		}
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}
	static PriorityQueue<Edge> pq;
	static int[] parents;
	static int[] size;
	static boolean[][] connected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		points = new int[N+1][2];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new int[] {x,y};
		}
		
		pq = new PriorityQueue<>();
		parents = new int[N+1];
		size = new int[N+1];
		makeSet();
		
		connected = new boolean[N+1][N+1];
		for (int i=0; i<M; i++) {  // 이미 연결된 곳 표시
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			union(s,e);
			connected[s][e] = true;
			connected[e][s] = true;
		}
		
		for (int i=1; i<N; i++) {
			for (int j=i+1; j<=N; j++) {
				if (connected[i][j]) continue;
				
				double w = calcDist(i,j);
				pq.offer(new Edge(i,j,w));
			}
		}
		
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (union(edge.s, edge.e)) {
				minLength += edge.w;
			}
		}
		System.out.printf("%.2f", minLength);
	}

	private static void makeSet() {
		for (int i=1; i<=N; i++) {
			parents[i] = i;
			size[i] = 1;
		}
	}

	private static boolean union(int x, int y) {
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		if (xRoot==yRoot) return false;
		
		if (size[xRoot] < size[yRoot]) {
			size[yRoot] += size[xRoot];
			parents[xRoot] = yRoot;
		} else {
			size[xRoot] += size[yRoot];
			parents[yRoot] = xRoot;
		}
		return true;
	}

	private static int findSet(int x) {
		if (x==parents[x]) return parents[x];
		return parents[x] = findSet(parents[x]);
	}

	private static double calcDist(int i, int j) {
		int x1 = points[i][0];
		int y1 = points[i][1];
		int x2 = points[j][0];
		int y2 = points[j][1];
		
		long xDiff = x1-x2;
		long yDiff = y1-y2;
		
		return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
	}
}
