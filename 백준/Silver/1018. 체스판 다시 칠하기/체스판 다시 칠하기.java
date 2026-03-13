import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] board;
	static int[][] startWithBlack = {
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0}
	};
	static int[][] startWithWhite = {
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1}
	};
	static int minCnt = 100;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 행
		M = Integer.parseInt(st.nextToken());  // 열
		board = new int[N][M];
		
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<M; j++) {
				char color = line.charAt(j);
				if (color=='B') board[i][j] = 0;  // 검정색 0
				else board[i][j] = 1;  // 흰색 1
			}
		}
		
		for (int i=0; i<=N-8; i++) {
			for (int j=0; j<=M-8; j++) {
				check(i,j);  // 맨 왼쪽 위 칸이 (i,j)인 경우 체크
			}
		}
		
		System.out.println(minCnt);
	}

	private static void check(int startR, int startC) {
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i=startR; i<startR+8; i++) {
			for (int j=startC; j<startC+8; j++) {
				if (board[i][j]!=startWithBlack[i-startR][j-startC]) {
					cnt1++;
				}
				if (board[i][j]!=startWithWhite[i-startR][j-startC]) {
					cnt2++;
				}
			}
		}
		
		minCnt = Math.min(minCnt, Math.min(cnt1, cnt2));
	}
}
