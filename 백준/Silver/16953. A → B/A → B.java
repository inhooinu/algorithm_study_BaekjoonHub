import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static long A, B;
	static boolean isAvailable;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		
		Queue<long[]> q = new ArrayDeque<>();
		q.offer(new long[] {A, 0});
		while (!q.isEmpty()) {
			long[] cur = q.poll();
			long n = cur[0];
			long cnt = cur[1];
			if (n==B) {
				System.out.println(cnt+1);
				isAvailable = true;
				break;
			}
			
			if (n*2 > B) continue;
			q.offer(new long[] {n*2, cnt+1});
			
			if (Long.parseLong(n+"1") > B) continue;
			q.offer(new long[] {Long.parseLong(n+"1"), cnt+1});
		}
		
		if (!isAvailable) {
			System.out.println(-1);
		}
	}
}
