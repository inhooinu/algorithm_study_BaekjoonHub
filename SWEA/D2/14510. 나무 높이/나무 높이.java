import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] tree;
	static int[] diff;
	static int cnt1;
	static int cnt2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			tree = new int[N];
			diff = new int[N];
			cnt1 = 0;
			cnt2 = 0;
			int maxH = -1;
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				int h = Integer.parseInt(st.nextToken());
				tree[i] = h;
				maxH = Math.max(maxH, h);
			}
			for (int i=0; i<N; i++) {
				int d = maxH - tree[i];
				diff[i] = d;
				cnt1 += d%2;
				cnt2 += d/2;
			}
			
			while (cnt2>cnt1+1) {
				cnt2--;
				cnt1+=2;
			}
			
			int days = -1;
			if (cnt2>=cnt1) {
				days = cnt2*2;
			} else {
				days = cnt1*2-1;
			}
			
//			System.out.println(Arrays.toString(tree));
//			System.out.println(Arrays.toString(diff));
//			System.out.println(cnt1 + " " + cnt2);
			System.out.println("#"+t+" "+days);
		}
	}
}
