import java.util.Scanner;

public class Main {
	static int[][] star;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		star = new int[N][2*N-1];
		
		star(0, 0, N); // (시작위치, 시작위치, 크기);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<2*N-1; j++) {
				sb.append(star[i][j]==1?"*":" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void star(int r, int c, int n) {
		if (n==3) {
			for (int i=0; i<3; i++) {
				for (int j=0; j<5; j++) {
					if (i==0 && j==2) star[r+i][c+j]=1;
					else if (i==1 && (j==1 || j==3)) star[r+i][c+j]=1;
					else if (i==2) star[r+i][c+j]=1;
				}
			}
		} else {
			star(r+0, c+n/2, n/2);
			star(r+n/2, c+0, n/2);
			star(r+n/2, c+n, n/2);
		}
	}
}
