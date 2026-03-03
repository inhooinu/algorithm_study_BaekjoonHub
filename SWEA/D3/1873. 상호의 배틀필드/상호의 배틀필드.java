import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int H, W;
	static char[][] map;
	static int N;
	static int curR, curC, dir;  // 0: 위, 1: 아래, 2: 왼쪽, 3: 오른쪽
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for (int i=0; i<H; i++) {
				String line = br.readLine();
				for (int j=0; j<W; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j]=='^') {
						curR = i;
						curC = j;
						dir = 0;
					} else if (map[i][j]=='v') {
						curR = i;
						curC = j;
						dir = 1;
					} else if (map[i][j]=='<') {
						curR = i;
						curC = j;
						dir = 2;
					} else if (map[i][j]=='>') {
						curR = i;
						curC = j;
						dir = 3;
					}
				}
			}
//			printMap();
			
			N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			for (int i=0; i<N; i++) {
				char c = line.charAt(i);
				if (c=='U') {
					up();
				} else if (c=='D') {
					down();
				} else if (c=='L') {
					left();
				} else if (c=='R') {
					right();
				} else if (c=='S') {
					shoot();
				}
//				printMap();
			}
			
			System.out.print("#"+t+" ");
			printMap();
		}
	}

	private static void shoot() {
		
		int nr = curR;
		int nc = curC;
		while (true) {
			nr = nr+dr[dir];
			nc = nc+dc[dir];
			if (!inRange(nr,nc)) break;
			if (map[nr][nc]=='*') {
				map[nr][nc] = '.';
				break;
			}
			if (map[nr][nc]=='#') {
				break;
			}
		}
		
	}

	private static void right() {
		dir = 3;
		map[curR][curC] = '>';
		int nr = curR;
		int nc = curC+1;
		
		if (!inRange(nr, nc)) return;
		if (map[nr][nc]=='.') {
			map[curR][curC] = '.';
			curR = nr;
			curC = nc;
			map[curR][curC] = '>';
		}
		
	}

	private static void left() {
		dir = 2;
		map[curR][curC] = '<';
		int nr = curR;
		int nc = curC-1;
		
		if (!inRange(nr, nc)) return;
		if (map[nr][nc]=='.') {
			map[curR][curC] = '.';
			curR = nr;
			curC = nc;
			map[curR][curC] = '<';
		}
		
	}

	private static void down() {
		dir = 1;
		map[curR][curC] = 'v';
		int nr = curR+1;
		int nc = curC;
		
		if (!inRange(nr, nc)) return;
		if (map[nr][nc]=='.') {
			map[curR][curC] = '.';
			curR = nr;
			curC = nc;
			map[curR][curC] = 'v';
		}
	}

	private static void up() {
		dir = 0;
		map[curR][curC] = '^';
		int nr = curR-1;
		int nc = curC;
		
		if (!inRange(nr, nc)) return;
		if (map[nr][nc]=='.') {
			map[curR][curC] = '.';
			curR = nr;
			curC = nc;
			map[curR][curC] = '^';
		}
	}

	private static boolean inRange(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}

	private static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
//				System.out.print(map[i][j]);
				sb.append(map[i][j]);
			}
//			System.out.println();
			sb.append("\n");
		}
//		System.out.println();
//		sb.append("\n");
		System.out.print(sb);
	}

}
