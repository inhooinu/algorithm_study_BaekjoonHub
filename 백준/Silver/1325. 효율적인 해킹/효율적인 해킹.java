import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static ArrayList<Integer>[] graph;
	static int[] visited;
	static int visitedId = 0;
	static int[] computerNum;
	static int maxCnt = 0;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new int[N+1];
		computerNum = new int[N+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[b].add(a);			
		}
		
		for (int i=1; i<=N; i++) {
			int cnt = bfs(i);
			computerNum[i] = cnt;
			maxCnt = Math.max(maxCnt, cnt);
		}
//		System.out.println(Arrays.toString(computerNum));
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; i++) {
			if (computerNum[i]==maxCnt) {
//				System.out.print(i+" ");
				sb.append(i+" ");
			}
		}
		System.out.println(sb);
	}

	private static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		int cnt = 0;
		
		visited[start] = ++visitedId;
		q.offer(start);
		while(!q.isEmpty()) {
			int cur = q.poll();
			cnt++;
			for (int next: graph[cur]) {
				if (visited[next]==visitedId) continue;
				visited[next] = visitedId;
				q.offer(next);
			}
		}
		
		return cnt;
	}
}