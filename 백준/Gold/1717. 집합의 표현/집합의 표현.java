import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[] parents;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		rank = new int[n+1];
		makeSet();
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (command==0) {  // 합집합 연산
				union(a,b);
			} else if (command==1) {  // 같은 집합에 포함되어 있는지 확인하는 연산
				if (find(a)==find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA==rootB) return false;
		
		if (rank[rootA] < rank[rootB]) {
			rank[rootB] += rank[rootA];
			parents[rootA] = parents[rootB];
		} else {
			rank[rootA] += rank[rootB];
			parents[rootB] = parents[rootA];
		}
		return true;
	}

	private static int find(int a) {
		if (a==parents[a]) return parents[a];
		return parents[a] = find(parents[a]);
	}

	private static void makeSet() {
		for (int i=0; i<=n; i++) {
			parents[i] = i;
			rank[i] = 1;
		}
	}
}
