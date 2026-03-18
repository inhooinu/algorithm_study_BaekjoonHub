import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] paper;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int cnt;
	static int maxArea;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		visited = new boolean[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (paper[i][j]==1 && !visited[i][j]) {
					int area = bfs(i,j);
					cnt++;
					maxArea = Math.max(maxArea, area);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(maxArea);
	}

	private static int bfs(int startR, int startC) {
		int area = 0;
		
		Queue<int[]> q = new ArrayDeque<>();
		visited[startR][startC] = true;
		area++;
		q.offer(new int[] {startR, startC});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			for (int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if (!inRange(nr,nc)) continue;
				if (visited[nr][nc]) continue;
				if (paper[nr][nc]==0) continue;
				visited[nr][nc] = true;
				area++;
				q.offer(new int[] {nr,nc});
			}
		}
		
		return area;
	}

	private static boolean inRange(int r, int c) {
		return r>=0 && r<n && c>=0 && c<m;
	}
}
