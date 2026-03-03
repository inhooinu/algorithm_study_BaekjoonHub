import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int N, K;
	static int[][] map;
	static int cnt;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N+2][N+2];
			cnt = 0;
			for (int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			printMap();
			
			for (int i=0; i<N-K+1; i++) {
				for (int j=1; j<=N; j++) {
					if (map[i][j]==0) {
						if (checkRow(i,j)) cnt++;
					}
				}
			}
			for (int i=1; i<=N; i++) {
				for (int j=0; j<N-K+1; j++) {
					if (map[i][j]==0) {
						if (checkCol(i,j)) cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

	private static boolean checkRow(int r, int c) {
		for (int i=r+1; i<r+1+K; i++) {
			if (map[i][c]==0) return false;
		}
		if (map[r+1+K][c]!=0) return false;
		return true;
	}
	
	private static boolean checkCol(int r, int c) {
		for (int i=c+1; i<c+1+K; i++) {
			if (map[r][i]==0) return false;
		}
		if (map[r][c+1+K]!=0) return false;
		return true;
	}

	private static void printMap() {
		for (int i=0; i<N+2; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

}
