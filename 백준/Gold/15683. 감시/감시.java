import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static List<CCTV> list;
	static class CCTV {
		int r;
		int c;
		int num;
		CCTV(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	static int minCnt;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		minCnt = N*M;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (0<map[i][j] && map[i][j]<6) {  // 1~5번 CCTV 리스트에 추가
					list.add(new CCTV(i,j,map[i][j]));
				}
			}
		}
		
		// CCTV 설치하기
		setCCTV(0);
		System.out.println(minCnt);
	}

	private static void setCCTV(int idx) {
		if (idx==list.size()) {  // 모든 CCTV의 방향을 결정하여 설치를 완료했으면
			int cnt = countArea();  // 사각 지대의 크기 구하기
//			System.out.println(cnt);
			minCnt = Math.min(minCnt, cnt);
			
//			for (int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			return;
		}
		
		// 현재 설치할 CCTV 정보
		int r = list.get(idx).r;
		int c = list.get(idx).c;
		int num = list.get(idx).num;
		for (int dir=0; dir<4; dir++) {
			// CCTV 감시 영역 표시
			markCCTVArea(r,c,num,dir);
			// 다음 CCTV로 넘어가기
			setCCTV(idx+1);
			// CCTV 감시 영역 표시 지우기
			removeCCTVArea(r,c,num,dir);
		}
	}

	private static void removeCCTVArea(int r, int c, int num, int dir) {
		int sr = r;
		int sc = c;
		while (true) {
			sr += dr[dir];
			sc += dc[dir];
			if (!inRange(sr,sc)) break;
			if (map[sr][sc]==6) break;
			if (1<=map[sr][sc] && map[sr][sc]<=6) continue;  // CCTV면 그대로 두기
			map[sr][sc]++;
		}
		if (num==2 || num==4 || num==5) {  // 반대 방향 체크
			int nr = r;
			int nc = c;
			int d = (dir+2)%4;
			while (true) {
				nr += dr[d];
				nc += dc[d];
				if (!inRange(nr,nc)) break;
				if (map[nr][nc]==6) break;
				if (1<=map[nr][nc] && map[nr][nc]<=6) continue;  // CCTV면 그대로 두기
				map[nr][nc]++;
			}
		}
		if (num>=3) {  // 수직 방향 체크
			int nr = r;
			int nc = c;
			int d = (dir+3)%4;
			while (true) {
				nr += dr[d];
				nc += dc[d];
				if (!inRange(nr,nc)) break;
				if (map[nr][nc]==6) break;
				if (1<=map[nr][nc] && map[nr][nc]<=6) continue;  // CCTV면 그대로 두기
				map[nr][nc]++;
			}
		}
		if (num==5) {
			int nr = r;
			int nc = c;
			int d = (dir+1)%4;
			while (true) {
				nr += dr[d];
				nc += dc[d];
				if (!inRange(nr,nc)) break;
				if (map[nr][nc]==6) break;
				if (1<=map[nr][nc] && map[nr][nc]<=6) continue;  // CCTV면 그대로 두기
				map[nr][nc]++;
			}
		}
		
	}

	private static void markCCTVArea(int r, int c, int num, int dir) {
		int sr = r;
		int sc = c;
		while (true) {
			sr += dr[dir];
			sc += dc[dir];
			if (!inRange(sr,sc)) break;
			if (map[sr][sc]==6) break;
			if (1<=map[sr][sc] && map[sr][sc]<=6) continue;  // CCTV면 그대로 두기
			map[sr][sc]--;
		}
		if (num==2 || num==4 || num==5) {  // 반대 방향 체크
			int nr = r;
			int nc = c;
			int d = (dir+2)%4;
			while (true) {
				nr += dr[d];
				nc += dc[d];
				if (!inRange(nr,nc)) break;
				if (map[nr][nc]==6) break;
				if (1<=map[nr][nc] && map[nr][nc]<=6) continue;  // CCTV면 그대로 두기
				map[nr][nc]--;
			}
		}
		if (num>=3) {  // 수직 방향 체크
			int nr = r;
			int nc = c;
			int d = (dir+3)%4;
			while (true) {
				nr += dr[d];
				nc += dc[d];
				if (!inRange(nr,nc)) break;
				if (map[nr][nc]==6) break;
				if (1<=map[nr][nc] && map[nr][nc]<=6) continue;  // CCTV면 그대로 두기
				map[nr][nc]--;
			}
		}
		if (num==5) {
			int nr = r;
			int nc = c;
			int d = (dir+1)%4;
			while (true) {
				nr += dr[d];
				nc += dc[d];
				if (!inRange(nr,nc)) break;
				if (map[nr][nc]==6) break;
				if (1<=map[nr][nc] && map[nr][nc]<=6) continue;  // CCTV면 그대로 두기
				map[nr][nc]--;
			}
		}
	}

	private static boolean inRange(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

	private static int countArea() {
		int cnt = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j]==0) cnt++;
			}
		}
		return cnt;
	}
}
