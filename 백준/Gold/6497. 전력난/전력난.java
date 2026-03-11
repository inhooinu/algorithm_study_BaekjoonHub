import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int m, n;
	static class Edge implements Comparable<Edge> {
		int s,e,w;
		public Edge(int s, int e, int w) {
			this.s=s; this.e=e; this.w=w;
		}
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static PriorityQueue<Edge> pq;
	static int[] parents;
	static int[] size;
	static int totalCost;
	static int requiredCost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if (m==0 && n==0) break;
			
			pq = new PriorityQueue<>();
			parents = new int[m];
			size = new int[m];
			totalCost = 0;
			requiredCost = 0;
			
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				pq.offer(new Edge(x,y,z));
				totalCost += z;
			}
			
			makeSet();
			
			int cnt = 0;
			while (!pq.isEmpty()) {
				Edge edge = pq.poll();
				if (union(edge.s,edge.e)) {
//					System.out.println(edge.s+" "+edge.e+" "+edge.w);
					requiredCost += edge.w;
					cnt++;
					if (cnt==m-1) break;
				}
			}
//			System.out.println(totalCost);
//			System.out.println(requiredCost);
			System.out.println(totalCost-requiredCost);
		}
	}

	private static void makeSet() {
		for (int i=0; i<m; i++) {
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
}
