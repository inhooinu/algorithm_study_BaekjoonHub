import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] paper;
	static int white;
	static int melody;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0,0,N);
		System.out.println(white);
		System.out.println(melody);
		
//		for (int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(paper[i]));
//		}
	}

	private static void cut(int r, int c, int size) {
		int sum = 0;
		for (int i=r; i<r+size; i++) {
			for (int j=c; j<c+size; j++) {
				sum+=paper[i][j];
			}
		}
		if (sum==0) {  // 모두 하얀색
			white++;
			return;
		}
		if (sum==size*size) {  // 모두 멜로디 색
			melody++;
			return;
		}
		
		// 색이 섞여있는 경우
		cut(r,c,size/2);
		cut(r,c+size/2,size/2);
		cut(r+size/2,c,size/2);
		cut(r+size/2,c+size/2,size/2);
	}
}
