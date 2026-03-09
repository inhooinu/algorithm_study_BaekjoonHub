import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N, K;
	static int[][] paper;
	static boolean[][] visited;
	static List<Integer> results;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		paper = new int[M][N];
		visited = new boolean[M][N];
		results = new ArrayList<>();
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for (int y=y1; y<y2; y++) {
				for (int x=x1; x<x2; x++) {
					paper[y][x] = 1;
				}
			}
		}
//		printPaper();
		
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				if (paper[i][j]==0 && !visited[i][j]) {
					int area = bfs(i,j);
					results.add(area);
				}
			}
		}
		
//		System.out.println(results);
		Collections.sort(results);
		System.out.println(results.size());
		for (int i=0; i<results.size(); i++) {
			System.out.print(results.get(i) + " ");
		}
	}

	private static int bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		int size = 0;
		
		visited[i][j] = true;
		q.offer(new int[] {i,j});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			size++;
			int r = cur[0];
			int c = cur[1];
			
			for (int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (!inRange(nr,nc)) continue;
				if (visited[nr][nc]) continue;
				if (paper[nr][nc]==1) continue;
				visited[nr][nc] = true;
				q.offer(new int[] {nr,nc});
			}
		}
		
		return size;
	}

	private static boolean inRange(int r, int c) {
		return r>=0 && r<M && c>=0 && c<N;
	}

	private static void printPaper() {
		for (int i=0; i<M; i++) {
			System.out.println(Arrays.toString(paper[i]));
		}
		System.out.println();
	}
}
