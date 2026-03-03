import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int V, E;
	static PriorityQueue<Edge> points;
	static class Edge implements Comparable<Edge> {
		int s, e, w;
		public Edge(int s, int e, int w) {
			this.s=s; this.e=e; this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static int result;
	static int[] p;
	static int[] r;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		points = new PriorityQueue<>();
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			points.offer(new Edge(s,e,w));
		}
		p = new int[V+1];
		r = new int[V+1];
		makeSet();
		int cnt = 0;
		result = 0;
		while (cnt!=V-1) {  // (정점-1)개 만큼의 간선이 연결되면 끝
			Edge edge = points.poll();
			if (union(edge.s, edge.e)) {  // 합칠 수 있으면
				cnt++;
				result+=edge.w;
			}
		}
		System.out.println(result);
	}

	private static boolean union(int x, int y) {
		x=find(x);
		y=find(y);
		if (x==y) return false;  // 이미 같은 집합 (연결하면 싸이클 생김)
		if (r[x]<r[y]) {  // 작은 트리를 큰 트리에 연결
			r[y]+=r[x];
			p[x]=y;
		} else {
			r[x]+=r[y];
			p[y]=x;
		}
		return true;
	}

	private static int find(int x) {
		if (x==p[x]) return p[x];
		else return p[x]=find(p[x]);
	}

	private static void makeSet() {  // unionFind를 위한 초기화
		for (int i=1; i<=V; i++) {
			p[i] = i;
			r[i] = 1;
		}
	}
	
}
