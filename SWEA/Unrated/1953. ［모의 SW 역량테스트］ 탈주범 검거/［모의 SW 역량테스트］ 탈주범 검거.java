import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 세로 크기
			M = Integer.parseInt(st.nextToken());  // 가로 크기
			R = Integer.parseInt(st.nextToken());  // 세로 위치
			C = Integer.parseInt(st.nextToken());  // 가로 위치
			L = Integer.parseInt(st.nextToken());  // 탈출 후 소요된 시간
			map = new int[N][M];
			result = 0;
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs(R,C);
			System.out.println("#"+t+" "+result);
		}
	}

	private static void bfs(int startR, int startC) {
		Queue<int[]> q = new ArrayDeque<>();
		visited = new boolean[N][M];
		
		visited[startR][startC] = true;
		q.offer(new int[] {startR,startC,1});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int time = cur[2];
			int type = map[r][c];
			if (time>L) break;
			result++;
			
			if (type==0) {
				continue;
			} else if (type==1) {
				// 위로 가는 경우
				int nr = r-1;
				int nc = c;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==2 || map[nr][nc]==5 || map[nr][nc]==6)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
				
				// 아래로 가는 경우
				nr = r+1;
				nc = c;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==7)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
				
				// 좌
				nr = r;
				nc = c-1;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==5)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
				
				// 우
				nr = r;
				nc = c+1;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==3 || map[nr][nc]==6 || map[nr][nc]==7)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
			} else if (type==2) {
				int nr = r-1;
				int nc = c;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==2 || map[nr][nc]==5 || map[nr][nc]==6)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
				
				nr = r+1;
				nc = c;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==7)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
			} else if (type==3) {
				// 좌
				int nr = r;
				int nc = c-1;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==5)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
				
				// 우
				nr = r;
				nc = c+1;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==3 || map[nr][nc]==6 || map[nr][nc]==7)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
			} else if (type==4) {
				// 위로 가는 경우
				int nr = r-1;
				int nc = c;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==2 || map[nr][nc]==5 || map[nr][nc]==6)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
				
				// 우
				nr = r;
				nc = c+1;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==3 || map[nr][nc]==6 || map[nr][nc]==7)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
			} else if (type==5) {
				// 아래로 가는 경우
				int nr = r+1;
				int nc = c;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==7)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
				
				// 우
				nr = r;
				nc = c+1;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==3 || map[nr][nc]==6 || map[nr][nc]==7)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
			} else if (type==6) {
				// 아래로 가는 경우
				int nr = r+1;
				int nc = c;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==7)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
				
				// 좌
				nr = r;
				nc = c-1;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==5)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
			} else if (type==7) {
				// 위로 가는 경우
				int nr = r-1;
				int nc = c;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==2 || map[nr][nc]==5 || map[nr][nc]==6)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
				// 좌
				nr = r;
				nc = c-1;
				if (inRange(nr, nc) 
					&& !visited[nr][nc] 
					&& (map[nr][nc]==1 || map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==5)) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,time+1});
				}
			}
			
		}
	}

	private static boolean inRange(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
