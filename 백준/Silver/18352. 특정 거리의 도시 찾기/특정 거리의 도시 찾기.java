import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K, X;  // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시의 번호
	static ArrayList<Integer>[] graph;
	static List<Integer> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		result = new ArrayList<>();
		
		bfs();
		if (result.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(result);
			for (int i=0; i<result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		visited[X] = true;
		q.offer(new int[] {X, 0});  // 출발도시
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int dist = cur[1];
			if (dist==K) {
				result.add(cur[0]);
				continue;
			}
			
			for (int next: graph[cur[0]]) {
				if (visited[next]) continue;
				visited[next] = true;
				q.offer(new int[] {next, dist+1});
			}
		}
	}
}
