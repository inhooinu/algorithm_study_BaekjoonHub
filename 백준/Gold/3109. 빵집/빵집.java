import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[][] maps;
	static boolean[][] visited;
	static int cnt;
	static boolean found;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		maps = new int[R][C];
		visited = new boolean[R][C];
		for (int i=0; i<R; i++) {
			String ss = br.readLine();
			char[] cs = ss.toCharArray();
			for (int j=0; j<C; j++) {
				if (cs[j]=='x') {
					maps[i][j] = 1;
				}
			}
		}
		
		for (int i=0; i<R; i++) {
			found = false;
			goGas(i, 0);
		}
		
		System.out.println(cnt);
		
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(maps[i]));
//		}
	}

	static void goGas(int r, int c) {
		if (found) return;  // 이미 파이프 설치한 경우
		if (!inRange(r, c)) return;  // 범위 벗어난 경우
		if (maps[r][c]==1) return;  // 도착한 위치에 건물이 있는 경우
		if (visited[r][c]) return;  // 이미 방문한 경우
		
		if (c==C-1) {
			cnt++;
			found = true;
			return;
		}
		
		visited[r][c]=true;
		
		goGas(r-1,c+1);
		goGas(r, c+1);
		goGas(r+1,c+1);
		
	}
	
	static boolean inRange(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
