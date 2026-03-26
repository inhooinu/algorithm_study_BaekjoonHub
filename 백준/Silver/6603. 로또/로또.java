import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int k;
	static int[] S;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k==0) break;
			
			S = new int[k];
			for (int i=0; i<k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			result = new int[6];
			select(0, 0);
			System.out.println();
		}
	}

	private static void select(int idx, int start) {
		if (idx==6) {
//			System.out.println(Arrays.toString(result));
			for (int i=0; i<6; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i=start; i<k; i++) {
			result[idx] = S[i];
			select(idx+1, i+1);
		}
	}
}
