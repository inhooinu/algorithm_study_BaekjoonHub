import java.io.*;
import java.util.*;

public class Main {

	static int R, C, M;
	static int[][] map;
	static Deque<int[]> sdq = new ArrayDeque<>();
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R + 1][C + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sdq.offer(new int[] {r, c, s, d, z});
			map[r][c] = z;
		}
		int index = 0;
		int result = 0;
		while(index <= C -1) {
			// 낚시왕이 오른쪽으로 한 칸 이동한다.
			index++;			
			
			// 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
			for (int i = 1; i <= R; i++) {
				if(map[i][index] != 0) {
					result += map[i][index];
					map[i][index] = 0;
					break;
				}
			}
			
			// 상어가 이동한다.
			sharkMove();
		}
		System.out.println(result);
	}
	
	static void sharkMove() {
		int[][] newMap = new int[R + 1][C + 1];
		Deque<int[]> nsdq = new ArrayDeque<>();
		while(!sdq.isEmpty()) {
			int[] cur = sdq.poll();
			int r = cur[0];
			int c = cur[1];
			int s = cur[2];
			int d = cur[3];
			int z = cur[4];
			if(map[r][c] != z) continue;
			int nr = r;
			int nc = c;
			for (int i = 0; i < s; i++) {
			    int tr = nr + dr[d];
			    int tc = nc + dc[d];
			    if (!check(tr, tc)) {
			        // 방향 반전
			        if (d == 1) d = 2;
			        else if (d == 2) d = 1;
			        else if (d == 3) d = 4;
			        else d = 3;

			        // 반전 후 한 칸 이동
			        nr += dr[d];
			        nc += dc[d];
			    } else {
			        nr = tr;
			        nc = tc;
			    }
			}
			// 이동 확정: 기존 상어 여부 확인
			if(newMap[nr][nc] != 0) {
				if(newMap[nr][nc] < z) {
					newMap[nr][nc] = z;
				}else {
					// 망. 잡아먹힘
					continue;
				}
			}else {
				newMap[nr][nc] = z;
			}
			nsdq.offer(new int[] {nr, nc, s, d, z});
		}
		sdq = nsdq;
		map = newMap;
	}
	
	static boolean check(int r, int c) {
		return r <= R && c <= C && r >= 1 && c >= 1;
	}
}