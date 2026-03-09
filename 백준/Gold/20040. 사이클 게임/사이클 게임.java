import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[] parents;
	static int[] rank;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n];
		rank = new int[n];
		makeSet();
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			cnt++;
			if (!union(x,y)) {  // 사이클이 생기는 경우
				System.out.println(cnt);
				System.exit(0);
			}
		}
		System.out.println(0);
	}

	private static void makeSet() {
		for (int i=0; i<n; i++) {
			parents[i] = i;
			rank[i] = 1;
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
		if (x==parents[x]) return parents[x];
		else return parents[x] = find(parents[x]);
	}
}
