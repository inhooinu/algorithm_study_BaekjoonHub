import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중
// 가장 짧은 것의 길이
public class Main {
	
	static int N;
	static int S;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(nums));
		
		int start = 0;
		int end = 0;
		int sum = 0;
		int minLength = N+1;

		while (true) {
			
			if (sum >= S) {
				minLength = Math.min(minLength, end-start);
				sum -= nums[start++];
			} else if (end==N) {
				break;
			} else {
				sum += nums[end++];
			}
			
		}
		if (minLength==N+1) {
			System.out.println(0);
		} else {
			System.out.println(minLength);
		}
	}
}
