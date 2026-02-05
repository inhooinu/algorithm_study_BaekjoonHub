import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int K;
	static int[][] magnet;
	static boolean[] same;
	static int totalScore;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());  // 회전 횟수
			magnet = new int[4][8];
			totalScore = 0;
			
			for (int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 회전
			int mNum = 0;
			int rDir = 0;
			for (int i=0; i<K; i++) {
				
				st = new StringTokenizer(br.readLine());
				mNum = Integer.parseInt(st.nextToken())-1;
				rDir = Integer.parseInt(st.nextToken());
				
				rotate(mNum, rDir, 0);
				
//				for (int j=0; j<4; j++) {
//					System.out.println(Arrays.toString(magnet[j]));
//				}
			}
				
			// 점수 계산
			for (int i=0; i<4; i++) {
				totalScore += magnet[i][0]*Math.pow(2, i);
			}
			
			System.out.printf("#%d %d\n", t, totalScore);
		}
	}

	// 맨처음만 양방향, 그 다음부터는 왼쪽 또는 오른쪽 자석만 보면서 돌려야함
	// 어느 방향을 볼 것인지 매개변수로
	private static void rotate(int mNum, int rDir, int dir) {
		
		same = new boolean[3];
		for (int i=0; i<3; i++) {
			if (magnet[i][2]==magnet[i+1][6]) {
				same[i] = true;
			}
		}
		
		if (mNum<0 || mNum>=4) return;
		if (dir<0) {  // 왼쪽 자석 보기
			if (mNum>=1 && !same[mNum-1]) rotate(mNum-1, rDir*-1, dir);
		} else if (dir>0) {  // 오른쪽 자석 보기
			if (mNum<3 && !same[mNum]) rotate(mNum+1, rDir*-1, dir);
		} else {  // 양쪽 자석 보기
			if (mNum>=1 && !same[mNum-1]) rotate(mNum-1, rDir*-1, -1);
			if (mNum<3 && !same[mNum]) rotate(mNum+1, rDir*-1, 1);
		}
		
		// 현재 자석 돌리기
		if (rDir==1) rotateR(mNum);
		if (rDir==-1) rotateL(mNum);
	}

	private static void rotateR(int mNum) {
		int temp = magnet[mNum][7];
		for (int i=7; i>0; i--) {
			magnet[mNum][i] = magnet[mNum][i-1];
		}
		magnet[mNum][0] = temp;
	}

	private static void rotateL(int mNum) {
		int temp = magnet[mNum][0];
		for (int i=0; i<7; i++) {
			magnet[mNum][i] = magnet[mNum][i+1];
		}
		magnet[mNum][7] = temp;
	}
}
