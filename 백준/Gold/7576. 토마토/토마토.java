import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N;
	static int[][] box;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				if (box[i][j]==1) {
					q.offer(new int[] {i,j});
				}
			}
		}
		
		bfs(q);
		
		int max = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (box[i][j]==0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, box[i][j]);
			}
		}
		
		System.out.println(max-1);
	}

	private static void bfs(Queue<int[]> q) {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			for (int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if (!inRange(nr,nc)) continue;
				if (box[nr][nc] != 0) continue;
				
				box[nr][nc] = box[r][c] + 1;
				q.offer(new int[] {nr,nc});
			}
		}
	}

	private static boolean inRange(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
