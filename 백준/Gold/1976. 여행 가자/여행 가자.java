import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 같은 집합에 속하는지 체크하는 프로그램
public class Main {
	
	static int N, M;
	static int[][] graph;
	static int[] plan;
	static int[] parents;
	static int[] size;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N+1][N+1];
		plan = new int[M];
		parents = new int[N+1];
		size = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝
		
		makeSet();
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (graph[i][j]==1) {
					union(i,j);
				}
			}
		}
		
		int group = 0;
		for (int i=0; i<M; i++) {
			if (i==0) {
				group = findSet(plan[i]);
			} else {
				if (group != findSet(plan[i])) {
					System.out.println("NO");
					return;
				} 
			}
		}
		
		System.out.println("YES");
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot==bRoot) return false;
		if (size[aRoot]<size[bRoot]) {
			size[bRoot] += size[aRoot];
			parents[aRoot] = bRoot;
		} else {
			size[aRoot] += size[bRoot];
			parents[bRoot] = aRoot;
		}
		return true;
	}

	private static int findSet(int x) {
		if (x==parents[x]) return parents[x];
		return parents[x] = findSet(parents[x]);
	}

	private static void makeSet() {
		for (int i=1; i<=N; i++) {
			parents[i] = i;
			size[i] = 1;
		}
	}
}
