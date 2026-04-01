import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  // 수빈이의 위치
		K = sc.nextInt();  // 동생의 위치
		
		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		int[] time = new int[100001];
		Arrays.fill(time, -1);
		
		int minTime = -1;
		int cnt = 0;
		
		time[N] = 0;
		q.offer(N);
		
		while (!q.isEmpty()) {
			int x = q.poll();
			int t = time[x];
//			System.out.println(x+" "+t);
			
			if (minTime!=-1 && t>minTime) break;
			if (x==K) {
				minTime = t;
				cnt++;
				continue;
			}
			
			if (x-1>=0 && (time[x-1]==-1 || time[x-1]==t+1)) {
				time[x-1] = t+1;
				q.offer(x-1);
			}
			
			if (x+1<=100000 && (time[x+1]==-1 || time[x+1]==t+1)) {
				time[x+1] = t+1;
				q.offer(x+1);
			}
			
			if (x*2<=100000 && (time[x*2]==-1 || time[x*2]==t+1)) {
				time[x*2] = t+1;
				q.offer(x*2);
			}
			
		}
		System.out.println(minTime);
		System.out.println(cnt);
	}
}
