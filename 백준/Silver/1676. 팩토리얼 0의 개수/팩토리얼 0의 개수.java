import java.util.Scanner;

// N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램
public class Main {
	
	static int N;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// 5의 개수 세기
		for (int i=1; i<=N; i++) {
			int cur = i;
			while (cur%5==0) {  // 5의 배수에 대해
				cur /= 5;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
