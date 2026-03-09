import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int N;  // 섬의 개수
	static int[] xPoints;
	static int[] yPoints;
	static double E;  // 환경 부담 세율
	static PriorityQueue<Edge> edges;
	static class Edge implements Comparable<Edge> {
		int s, e;
		long w;
		public Edge(int s, int e, long w) {
			this.s=s; this.e=e; this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}
	static int[] parents;
	static int[] rank;
	
	static double result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			xPoints = new int[N];
			yPoints = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				xPoints[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				yPoints[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			edges = new PriorityQueue<>();
			parents = new int[N];
			rank = new int[N];
			result = 0;
			
			for (int i=0; i<N-1; i++) {
				for (int j=i+1; j<N; j++) {
//					System.out.println(i+" "+j);
					long xDiff = Math.abs(xPoints[i]-xPoints[j]);
					long yDiff = Math.abs(yPoints[i]-yPoints[j]);
					long L = xDiff*xDiff + yDiff*yDiff;
					edges.offer(new Edge(i,j,L));
				}
			}
			
			makeSet();
			int cnt = 0;
			while (cnt!=N-1) {
				Edge edge = edges.poll();
				if (union(edge.s, edge.e)) {
					cnt++;
					result += E*edge.w;
				}
			}
			
			System.out.printf("#%d %.0f", t, result);
			System.out.println();
		}
	}

	private static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot==yRoot) return false;
		if (rank[xRoot] < rank[yRoot]) {
			rank[yRoot] += rank[xRoot];
			parents[xRoot] = yRoot;
		} else {
			rank[xRoot] += rank[yRoot];
			parents[yRoot] = xRoot;
		}
		return true;
	}

	private static int find(int x) {
		if (parents[x]==x) return parents[x];
		return parents[x] = find(parents[x]);
	}

	private static void makeSet() {
		for (int i=0; i<N; i++) {
			parents[i] = i;
			rank[i] = 1;
		}
	}
}
