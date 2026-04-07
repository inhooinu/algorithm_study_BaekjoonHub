import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N;
	static long[][] cnt;
	static int num = 1000000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = new long[N+1][10];
		
		// 길이가 1인 경우 처리
		for (int k=1; k<=9; k++) {
			cnt[1][k] = 1;
		}
		
		// 길이가 l, 마지막 수가 k인 경우
		for (int l=2; l<=N; l++) {
			for (int k=0; k<=9; k++) {
				if (k==0) {
					cnt[l][k] = cnt[l-1][k+1]%num;
				} else if (k<9) {
					cnt[l][k] = (cnt[l-1][k-1] + cnt[l-1][k+1])%num;
				} else {
					cnt[l][k] = cnt[l-1][k-1]%num;
				}
			}
		}
		
//		for (int i=0; i<=N; i++) {
//			System.out.println(Arrays.toString(cnt[i]));
//		}
		
		long result = 0;
		for (int k=0; k<=9; k++) {
			result = (result + cnt[N][k])%num;
		}
		System.out.println(result);
	}
}
