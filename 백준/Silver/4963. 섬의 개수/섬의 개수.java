import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int w;
	static int h;
	static int cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w==0 && h==0) {  // w=0, h=0으로 입력이 들어오면 종료
				break;
			}
			map = new int[h][w];
			for (int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[h][w];
			
			cnt = 0;
			for (int i=0; i<h; i++) {
				for (int j=0; j<w; j++) {
					if (map[i][j]==1 && !visited[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			
//			// visited 출력
//			for (int i=0; i<h; i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
			System.out.println(cnt);
			
		}
		
	}

	private static void dfs(int r, int c) {
		
		if (!inRange(r,c)) return;
		if (map[r][c]==0) return;
		if (visited[r][c]) return;
		
		// 방문처리
		for (int dir=0; dir<8; dir++) {
			visited[r][c] = true;
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			dfs(nr, nc);
		}
		
	}

	private static boolean inRange(int r, int c) {
		return r>=0 && r<h && c>=0 && c<w;
	}
}
