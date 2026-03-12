import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int V, E;
	static int[][] cost;
	final static int INF = Integer.MAX_VALUE;
	static int result = INF;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		cost = new int[V+1][V+1];
		for (int i=1; i<=V; i++) {  // cost 초기화
			for (int j=1; j<=V; j++) {
				cost[i][j] = INF;
			}
		}
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			cost[a][b] = Math.min(cost[a][b], c);
		}
//		printCost();
		
		for (int k=1; k<=V; k++) {
			for (int i=1; i<=V; i++) {
				for (int j=1; j<=V; j++) {
					if (cost[i][k]==INF || cost[k][j]==INF) continue;
					if (cost[i][j] > cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}
//		printCost();
		
		for (int i=1; i<=V; i++) {
			for (int j=1; j<=V; j++) {
				if (cost[i][j]==INF || cost[j][i]==INF) continue;
				result = Math.min(result, cost[i][j]+cost[j][i]);
			}
		}
		System.out.print(result==INF ? -1 : result);
	}

	private static void printCost() {
		for (int i=1; i<=V; i++) {
			for (int j=1; j<=V; j++) {
				System.out.print(cost[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
