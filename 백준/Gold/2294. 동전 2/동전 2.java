import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n, k;
	static int[] value;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		value = new int[n];
		cnt = new int[k+1];
		Arrays.fill(cnt, Integer.MAX_VALUE);
		
		for (int i=0; i<n; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(value);
//		System.out.println(Arrays.toString(value));
		
		cnt[0] = 0;  // 가치의 합이 0원이 되도록 하는 경우는 0
		for (int i=1; i<=k; i++) {
			int minCnt = Integer.MAX_VALUE;
			for (int j=0; j<n; j++) {
				if (i>=value[j] && cnt[i-value[j]]!=Integer.MAX_VALUE) {
					int temp = cnt[i-value[j]] + 1;
					minCnt = Math.min(minCnt, temp);
				}
			}
			cnt[i] = minCnt;
		}
		
		if (cnt[k]==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(cnt[k]);
	}
}
