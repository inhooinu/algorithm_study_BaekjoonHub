import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int T;
	static int N;
	static int X;
	static int M;
	static int[][] report;
	static int[] hamsters;
	static int maxCnt;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			report = new int[M][3];
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				report[i][0] = Integer.parseInt(st.nextToken());  // l
				report[i][1] = Integer.parseInt(st.nextToken());  // r
				report[i][2] = Integer.parseInt(st.nextToken());  // s
			}
		
			hamsters = new int[N];
			maxCnt = -1;
			result = new int[N];
			select(0);
			System.out.printf("#%d ", t);
			if (maxCnt==-1) {  // 만족하는 햄스터 배치가 없는 경우
				System.out.println("-1");
			} else {
				for (int i=0; i<N; i++) {
					System.out.print(result[i]+" ");
				}
				System.out.println();
			}
		}
	}

	private static void select(int idx) {
		if (idx==N) {
//			System.out.println(Arrays.toString(hamsters));
			if (satisfied()) {
				int cnt = 0;
				for (int i=0; i<N; i++) {
					cnt += hamsters[i];
				}
				if (maxCnt<cnt) {
					maxCnt = cnt;
					result = hamsters.clone();
				}
//				System.out.println(maxCnt);
//				System.out.println(Arrays.toString(result));
			}
			return;
		}
		for (int i=0; i<=X; i++) {
			hamsters[idx]=i;
			select(idx+1);
		}
	}

	private static boolean satisfied() {
		
		for (int i=0; i<M; i++) {
			int l = report[i][0];
			int r = report[i][1];
			int s = report[i][2];
			int sum = 0;
			for (int j=l-1; j<r; j++) {
				sum += hamsters[j];
			}
			
			if (sum!=s) return false;
		}
		
		return true;
	}
}
