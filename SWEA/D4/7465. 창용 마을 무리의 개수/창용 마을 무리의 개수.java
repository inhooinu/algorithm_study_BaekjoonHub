import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int N, M;  // 사람의 수, 서로를 알고 있는 사람의 관계 수
	static int[] parents;
	static int[] rank;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			rank = new int[N+1];
			cnt = 0;
			
			makeSet();
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				union(p1,p2);
			}
			
			for (int i=1; i<=N; i++) {
				if (parents[i]==i) cnt++;
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}

	private static boolean union(int p1, int p2) {
		int rootP1 = find(p1);
		int rootP2 = find(p2);
		if (rootP1==rootP2) return false;
		
		if (rank[rootP1] < rank[rootP2]) {
			rank[rootP2] += rank[rootP1];
			parents[rootP1] = parents[rootP2];
		} else {
			rank[rootP1] += rank[rootP2];
			parents[rootP2] = parents[rootP1];
		}
		return true;
	}

	private static int find(int p) {
		if (p==parents[p]) return parents[p];
		else return parents[p] = find(parents[p]);
	}

	private static void makeSet() {
		for (int i=1; i<=N; i++) {
			parents[i] = i;
		}
		for (int i=1; i<=N; i++) {
			rank[i] = 1;
		}
	}
}
