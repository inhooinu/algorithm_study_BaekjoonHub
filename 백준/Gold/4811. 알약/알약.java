import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 카탈란 수를 이용한 풀이
		Scanner sc = new Scanner(System.in);
		while (true) {
			int N = sc.nextInt();
			if (N==0) break;
			
			long result = 1;
			for (int i=0; i<N; i++) {
				result = result * (2*N-i)/(1+i);
			}
			result = result/(N+1);
			
			System.out.println(result);
		}
	}
}
