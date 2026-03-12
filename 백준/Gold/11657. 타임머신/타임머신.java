import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] time;
	final static int INF = Integer.MAX_VALUE/100;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		time = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				time[i][j] = INF;
			}
			time[i][i] = 0;
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			time[A][B] = Math.min(time[A][B], C);
		}
		
		for (int k=1; k<=N; k++) {
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					if (time[i][k]==INF || time[k][j]==INF) continue;
					if (time[i][j] > time[i][k] + time[k][j]) {
						time[i][j] = time[i][k] + time[k][j];
					}
				}
			}
		}
		
		for (int i=1; i<=N; i++) {
			if (time[1][i]!=INF && time[i][i]<0) {
				System.out.println(-1);
				return;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int j=2; j<=N; j++) {
//			System.out.println(time[1][j]==INF ? -1 : time[1][j]);
			sb.append(time[1][j]==INF ? -1 : time[1][j]).append("\n");
		}
		System.out.print(sb);
	}
}
