
// 모든 작업을 완료하기 위해 필요한 최소 시간 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] time;
	static int[] totalTime;
	static ArrayList<Integer>[] graph;
	static int[] indeg;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		time = new int[N+1];
		totalTime = new int[N+1];
		graph = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		indeg = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			
			int cnt = Integer.parseInt(st.nextToken());
			indeg[i] = cnt;
			for (int j=0; j<cnt; j++) {
				int n = Integer.parseInt(st.nextToken());
				graph[n].add(i);
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();		
		for (int i=1; i<=N; i++) {
			totalTime[i] = time[i];
			
			if (indeg[i]==0) {
				q.offer(i);
			}
		}
//		System.out.println(Arrays.toString(totalTime));
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next: graph[cur]) {
				indeg[next]--;
				totalTime[next] = Math.max(totalTime[next], totalTime[cur] + time[next]);
				
				if (indeg[next]==0) {
					q.offer(next);
				}
			}
		}
//		System.out.println(Arrays.toString(totalTime));
		
		for (int i=1; i<=N; i++) {
			result = Math.max(result, totalTime[i]);
		}
		System.out.println(result);
	}
}
