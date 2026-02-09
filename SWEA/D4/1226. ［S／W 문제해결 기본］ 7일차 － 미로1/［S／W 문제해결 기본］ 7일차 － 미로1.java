import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// 주어진 미로의 출발점으로부터 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램
public class Solution {
	// 미로의 시작점 = 2
	// 미로의 도착점 = 3
	static int result;
	static int maze[][];
	static boolean visited[][];
	static int sr, sc, er, ec;
	static class Node {
		int r;
		int c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		for (int t=1; t<=10; t++) {
			maze = new int[16][16];
			visited = new boolean[16][16];
			
			int caseNum = Integer.parseInt(br.readLine());
			for (int i=0; i<16; i++) {
				String line = br.readLine();
				for (int j=0; j<16; j++) {
					maze[i][j] = line.charAt(j)-'0';
					if (maze[i][j]==2) {
						sr = i;
						sc = j;
					}
					if (maze[i][j]==3) {
						er = i;
						ec = j;
					}
				}
			}
			
			result = bfs(sr,sc);
			System.out.printf("#%d %d", t, result);
			System.out.println();
		}
	}

	private static int bfs(int r, int c) {
		Queue<Node> queue = new ArrayDeque<>();
		visited[r][c] = true;
		queue.offer(new Node(r,c));  // 시작점 넣기
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int curR = node.r;
			int curC = node.c;
			if (maze[curR][curC]==3) return 1;  // 도착
			
			for (int dir=0; dir<4; dir++) {  // 4방 탐색
				int nr = curR + dr[dir];
				int nc = curC + dc[dir];
				if (!inRange(nr,nc)) continue;  // 범위를 벗어났으면
				if (visited[nr][nc]) continue;  // 이미 방문했으면
				if (maze[nr][nc]==1) continue;  // 벽이면
				visited[nr][nc] = true;  // 방문 처리
				queue.offer(new Node(nr,nc));
			}
		}
		
		return 0;
	}

	private static boolean inRange(int nr, int nc) {
		return nr>=0 && nr<16 && nc>=0 && nc<16;
	}
}
