import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] arr;
	static int[][] arrSum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		arrSum = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
					arrSum[i][j] = arr[i][j] + arrSum[i-1][j] + arrSum[i][j-1] - arrSum[i-1][j-1];
			}
		}
		
//		for (int i=0; i<=N; i++) {
//			System.out.println(Arrays.toString(arrSum[i]));
//		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			System.out.println(sum(x1,y1,x2,y2));
		}
	}

	private static int sum(int x1, int y1, int x2, int y2) {
		int result = arrSum[x2][y2] - arrSum[x2][y1-1] - arrSum[x1-1][y2] + arrSum[x1-1][y1-1];
		return result;
	}
}
