import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] cost;
	static int[][] sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		sum = new int[N][3];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sum[0][0] = cost[0][0];
		sum[0][1] = cost[0][1];
		sum[0][2] = cost[0][2];
		for (int i=1; i<N; i++) {
			sum[i][0] = cost[i][0] + Math.min(sum[i-1][1], sum[i-1][2]);  // 현재 집이 빨강인 경우
			sum[i][1] = cost[i][1] + Math.min(sum[i-1][0], sum[i-1][2]);  // 현재 집이 초록인 경우
			sum[i][2] = cost[i][2] + Math.min(sum[i-1][0], sum[i-1][1]);  // 현재 집이 파랑인 경우
		}
		
		int result = Math.min(sum[N-1][0], sum[N-1][1]);
		result = Math.min(result, sum[N-1][2]);
		System.out.println(result);
	}
}
