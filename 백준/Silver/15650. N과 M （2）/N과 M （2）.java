import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] nums;
	static int[] result;
	
	public static void main(String[] args) {
		// 1부터 N까지 자연수 중에서 중복 없이 M개를 고르는 수열
		// 오름차순으로 출력
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		// 1부터 N까지 자연수 배열 만들기
		nums = new int[N];
		for (int i=0; i<N; i++) {
			nums[i]=i+1;
		}
		
		result = new int[M];
		select(0,0);  // 0번째 위치부터 숫자 선택하기
	}
	
	public static void select(int start, int idx) {
		if (idx==M) {
			for (int i=0; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i=start; i<N; i++) {
			result[idx]=nums[i];
			select(i+1, idx+1);
		}
	}
}
