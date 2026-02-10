import java.util.Scanner;

public class Main {
	
	static int N;
	static boolean[] col;
	static boolean[] slash;
	static boolean[] bSlash;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		col = new boolean[N+1];
		slash = new boolean[2*N+1];
		bSlash = new boolean[2*N+1];
		setQueen(1);
		System.out.println(cnt);
	}

	private static void setQueen(int row) {
		
		if (row==N+1) {  // 다 놓은 경우
			cnt++;
			return;
		}
		
		for (int c=1; c<=N; c++) {
			if (col[c] || slash[row+c] || bSlash[row-c+(N+1)]) continue;  // 놓을 수 있는지 체크
			col[c] = slash[row+c] = bSlash[row-c+(N+1)] = true;
			setQueen(row+1);
			col[c] = slash[row+c] = bSlash[row-c+(N+1)] = false;
		}
		
	}
}
