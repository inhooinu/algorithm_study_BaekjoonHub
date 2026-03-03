import java.util.*;
import java.io.*;

public class Solution {

	static int T; // 테스트 케이스 수
	static int H, W; // H:높이, W:너비
	static int N; 
	static char[][] map;
	static int cr, cc;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
					
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						cr = i;
						cc = j;
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			String cmdString = br.readLine();
			for (int i = 0; i < N; i++) {
				char cmd = cmdString.charAt(i);
				if(cmd == 'U') {
					map[cr][cc] = '^';
					move(-1, 0);
				} else if(cmd == 'D') {
					map[cr][cc] = 'v';
					move(1, 0);
				} else if(cmd == 'L') {
					map[cr][cc] = '<';
					move(0, -1);
				} else if(cmd == 'R') {
					map[cr][cc] = '>';
					move(0, 1);
				} else if(cmd == 'S') {
					shoot();
				}
			}
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');

			}
//			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void move(int dr, int dc) {
		int nr = cr + dr;
		int nc = cc + dc;
		if(!check(nr, nc)) return;
		if(map[nr][nc] != '.') return;
		map[nr][nc] = map[cr][cc];
		map[cr][cc] = '.';
		cr = nr;
		cc = nc;
	}
	
	static void shoot() {
		int ar = cr;
		int ac = cc;
		int dr = 0, dc = 0;
		if(map[cr][cc] == '^') {
			dr = -1;
		}else if(map[cr][cc] == 'v') {
			dr = 1;
		}else if(map[cr][cc] == '<') {
			dc = -1;
		}else if(map[cr][cc] == '>') {
			dc = 1;
		}
		while(true) {
			ar += dr;
			ac += dc;
			if(!check(ar, ac)) break;
			if(map[ar][ac] == '#') break;
			if(map[ar][ac] == '*') {
				map[ar][ac] = '.';
				break;
			}
		}
	}
	static boolean check(int r, int c) {
		return r < H && c < W && r >= 0 && c >= 0;
	}

}
