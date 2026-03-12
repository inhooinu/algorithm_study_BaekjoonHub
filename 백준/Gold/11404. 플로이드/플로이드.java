import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;  // n개의 도시, m개의 버스
	static final int INF = Integer.MAX_VALUE;
	static int[][] cost;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		cost = new int[n+1][n+1];
		
		for (int i=1; i<=n; i++) {  // cost 무한으로 초기화
			for (int j=1; j<=n; j++) {
				cost[i][j] = INF;
			}
		}
		for (int i=1; i<=n; i++) {  // 자기자신으로 가는 비용은 0
			cost[i][i] = 0;
		}
		for (int i=0; i<m; i++) {  // 시작 도시 a에서 도착 도시 b로 가는데 필요한 비용 c
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			cost[a][b] = Math.min(cost[a][b], c);
		}
//		printCost();
//		System.out.println();
		
		for (int k=1; k<=n; k++) {
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					if (cost[i][k]==INF || cost[k][j]==INF) continue;
					if (cost[i][j] > cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}
		printCost();
	}

	private static void printCost() {
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				System.out.print((cost[i][j]==INF ? 0 : cost[i][j])+" ");
			}
			System.out.println();
		}
	}	
}
