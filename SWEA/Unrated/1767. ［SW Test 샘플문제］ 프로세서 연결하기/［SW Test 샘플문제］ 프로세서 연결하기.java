import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 최대한 많은 core에 전원을 연결하였을 경우 전선 길이의 합 구하기
// 여러 방법이 있을 경우 전선 길이의 합이 최소가 되는 값 구하기
// 최대한 많은 core 연결 -> 전선 길이의 합이 최소
public class Solution {
	
	static int maxCoreCnt;
	static int minLength;
	
	static int N;
	static int[][] processor;
	static List<Core> cores;
	static class Core {
		int r;
		int c;
		Core(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			
			maxCoreCnt = 0;
			minLength = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			processor = new int[N][N];
			cores = new ArrayList<>();
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					processor[i][j] = Integer.parseInt(st.nextToken());
					// 가장자리에 위치하지 않은 core 체크
					if (processor[i][j]==1) {
						if (i==0 || i==N-1 || j==0 || j==N-1) continue;  // 가장자리에 위치한 core
						cores.add(new Core(i,j));
					}
				}
			}
			
			setPower(0, 0, 0);
			
			System.out.println("#"+t+" "+minLength);
		}
	}

	private static void setPower(int idx, int coreCnt, int length) {
		if (idx==cores.size()) {  // 모든 core에 대해 전원을 연결한 경우
			if (coreCnt > maxCoreCnt) {
				maxCoreCnt = coreCnt;
				minLength = length;
			} else if (coreCnt == maxCoreCnt) {
				minLength = Math.min(minLength, length);
			}
			
//			for (int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(processor[i]));
//			}
//			System.out.println();
			return;
		}
		
		int r = cores.get(idx).r;
		int c = cores.get(idx).c;
		for (int dir=0; dir<4; dir++) {  // 전선을 놓을 수 있는 모든 방향에 대하여
			// 전선 연결하기
			if (!isAvailable(r,c,dir)) continue;
			int l = drawLine(r,c,dir);
			
			// 다음 core로 넘어가기
			setPower(idx+1, coreCnt+1, length+l);
			
			// 전선 지우기
			removeLine(r,c,dir);
		}
		setPower(idx+1, coreCnt, length);  // 전선을 연결하지 않는 경우
	}

	private static void removeLine(int r, int c, int dir) {
		int nr = r;
		int nc = c;
		
		while (true) {
			nr += dr[dir];
			nc += dc[dir];
			if (nr<0 || nr>=N || nc<0 || nc>=N) break;
			processor[nr][nc] = 0;  // 전선 지우기
		}
	}

	private static int drawLine(int r, int c, int dir) {
		int cnt = 0;
		int nr = r;
		int nc = c;
		
		while (true) {
			nr += dr[dir];
			nc += dc[dir];
			if (nr<0 || nr>=N || nc<0 || nc>=N) break;
			processor[nr][nc] = 2;  // 전선 놓기
			cnt++;
		}
		
		return cnt;
	}

	private static boolean isAvailable(int r, int c, int dir) {
		int nr = r;
		int nc = c;
		
		while (true) {
			nr += dr[dir];
			nc += dc[dir];
			
			if (nr<0 || nr>=N || nc<0 || nc>=N) return true;
			// 전선 또는 core가 있는 경우 false
			if (processor[nr][nc]>=1) return false;
		}
	}
}
