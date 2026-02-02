import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N개의 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 됨
// 고른 수열은 비내림차순
public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
//		System.out.println(Arrays.toString(nums));
		select(0,0);
	}

	private static void select(int idx, int start) {
		if (idx==M) {
			for (int i=0; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (idx>0 && result[idx-1]>nums[i]) continue;
			result[idx] = nums[i];
			select(idx+1, i+1);
		}
	}
	
	
}
