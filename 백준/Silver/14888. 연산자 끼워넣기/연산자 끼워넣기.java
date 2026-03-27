import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] nums;
	static int[] operatorCnt;
	static int[] operatorOrder;
	static int maxResult = Integer.MIN_VALUE;
	static int minResult = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		operatorCnt = new int[4];
		operatorOrder = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			operatorCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		select(0);
		System.out.println(maxResult);
		System.out.println(minResult);
	}

	private static void select(int idx) {
		if (idx==N-1) {
//			System.out.println(Arrays.toString(operatorOrder));
			
			calc(operatorOrder);
			
			return;
		}
		
		for (int i=0; i<4; i++) {
			if (operatorCnt[i]<=0) continue;
			
			operatorOrder[idx] = i;
			operatorCnt[i]--;
			
			select(idx+1);
			
			operatorCnt[i]++;
		}
	}

	private static void calc(int[] operatorOrder) {
		int result = nums[0];
		for (int i=0; i<N-1; i++) {
			int operator = operatorOrder[i];
			int num = nums[i+1];
			
			if (operator==0) {
				result = result + num;
			} else if (operator==1) {
				result = result - num;
			} else if (operator==2) {
				result = result * num;
			} else {
				if (result<0) {
					result = -result;
					result = result / num;
					result = -result;
				} else {
					result = result / num;
				}
			}
		}
		
		maxResult = Math.max(maxResult, result);
		minResult = Math.min(minResult, result);
	}

	
}
