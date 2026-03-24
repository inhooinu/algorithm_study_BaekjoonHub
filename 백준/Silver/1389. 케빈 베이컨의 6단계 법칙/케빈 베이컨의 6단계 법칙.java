import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;  // 유저의 수, 친구 관계의 수
	static ArrayList<Integer>[] graph;
	static int minNum = Integer.MAX_VALUE;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for (int i=1; i<=N; i++) {
			int num = bfs(i);
			if (minNum > num) {
				minNum = num;
				result = i;
			}
		}
		
		System.out.println(result);
	}

	private static int bfs(int start) {
		boolean[] visited = new boolean[N+1];
		Queue<int[]> q = new ArrayDeque<>();
		int[] minDist = new int[N+1];
		
		visited[start] = true;
		q.offer(new int[] {start,0});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int idx = cur[0];
			int dist = cur[1];
			minDist[idx] = dist;
			
			for (int next: graph[idx]) {
				if (visited[next]) continue;
				visited[next] = true;
				q.offer(new int[] {next, dist+1});
			}
		}
		
//		System.out.println(Arrays.toString(minDist));
		int sum = 0;
		for (int i=0; i<minDist.length; i++) {
			sum += minDist[i];
		}
		return sum;
	}
}
