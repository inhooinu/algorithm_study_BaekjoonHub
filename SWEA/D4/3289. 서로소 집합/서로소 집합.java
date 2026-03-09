import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int n, m;  // n개의 집합, m번의 연산
	static int[] parents;
	static int[] rank;
	static String result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			rank = new int[n+1];
			result = "";
			
			makeSet();
			for (int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (command==0) {  // 합집합 연산
					union(a,b);
				} else if (command==1) {  // 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산
					if (find(a)==find(b)) result += "1";
					else result += "0";
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA==rootB) return false;
		if (rank[rootA]<rank[rootB]) {
			rank[rootB] += rank[rootA];
			parents[rootA] = rootB;
		} else {
			rank[rootA] += rank[rootB];
			parents[rootB] = rootA;
		}
		return true;
	}

	private static int find(int a) {
		if (parents[a]==a) return parents[a];
		else return parents[a] = find(parents[a]);
	}

	private static void makeSet() {
		for (int i=1; i<=n; i++) {
			parents[i] = i;
		}
		for (int i=1; i<=n; i++) {
			rank[i] = 1;
		}
	}
}
