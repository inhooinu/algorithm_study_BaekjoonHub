import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] field;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		field = new int[6][2];
		for (int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			field[i][0] = d;
			field[i][1] = l;
		}
		
//		for (int i=0; i<6; i++) {
//			System.out.print(Arrays.toString(field[i]));
//			System.out.println();
//		}
		
		int sum = 0;
		int maxW = 0;
		int maxH = 0;
		// 동쪽: 1, 서쪽: 2, 남쪽: 3, 북쪽: 4
		for (int i=0; i<6; i++) {
			if (field[i][0]==1 || field[i][0]==2) {
				maxW = Math.max(maxW, field[i][1]);
			} else {
				maxH = Math.max(maxH, field[i][1]);
			}
			sum += field[i][1]*field[(i+1)%6][1];
		}
		int area = sum - 2*maxW*maxH;
		System.out.println(area*K);
	}
}
