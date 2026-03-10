import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 별자리를 만드는 최소 비용 구하기
public class Main {
	
	static int n;
	static double[][] stars;
	static class Edge implements Comparable<Edge> {
		int s,e;
		double w;
		public Edge(int s, int e, double w) {
			this.s=s; this.e=e; this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}
	static int parents[];
	static int size[];
	static double totalCost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		stars = new double[n][2];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		// 모든 가능한 두 별의 조합에 대해
		for (int i=0; i<n-1; i++) {
			for (int j=i; j<n; j++) {
				double w = calcCost(i,j);
				pq.offer(new Edge(i,j,w));
			}
		}
		
		parents = new int[n];
		size = new int[n];
		makeSet();
		
		int cnt = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (union(edge.s, edge.e)) {
				totalCost += edge.w;
				cnt++;
				if (cnt==n-1) break;
			}
		}
		
		System.out.printf("%.2f", totalCost);
	}

	private static void makeSet() {
		for (int i=0; i<n; i++) {
			parents[i] = i;
			size[i] = 1;
		}
	}

	private static boolean union(int s, int e) {
		int sRoot = findSet(s);
		int eRoot = findSet(e);
		if (sRoot==eRoot) return false;
		
		if (size[sRoot]<size[eRoot]) {
			size[eRoot] += size[sRoot];
			parents[sRoot] = parents[eRoot];
		} else {
			size[sRoot] += size[eRoot];
			parents[eRoot] = parents[sRoot];
		}
		return true;
	}

	private static int findSet(int x) {
		if (parents[x]==x) return x;
		return parents[x] = findSet(parents[x]);
	}

	private static double calcCost(int i, int j) {
		double xDiff = stars[i][0] - stars[j][0];
		double yDiff = stars[i][1] - stars[j][1];
		
		return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
	}
}
