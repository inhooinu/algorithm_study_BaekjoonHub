import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;  // 전체 사람의 수, 부모 자식들 간의 관계의 수
	static int t1, t2;
	static ArrayList<Integer>[] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		t1 = Integer.parseInt(st.nextToken());
		t2 = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		for (int i=1; i<=n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}
		
		bfs();
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n+1];
		
		visited[t1] = true;
		q.offer(new int[] {t1,0});
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int p = cur[0];
			int cnt = cur[1];
			if (p==t2) {
				System.out.println(cnt);
				return;
			}
			
			for (int next: graph[p]) {
				if (visited[next]) continue;
				visited[next] = true;
				q.offer(new int[] {next, cnt+1});
			}
		}
		System.out.println(-1);
		return;
	}
}
