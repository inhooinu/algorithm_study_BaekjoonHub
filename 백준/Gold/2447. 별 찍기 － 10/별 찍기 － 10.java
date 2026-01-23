import java.util.Scanner;

public class Main {
	static int[][] star;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		star = new int[N][N];
		printStar(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				sb.append(star[i][j]==1?"*":" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void printStar(int r, int c, int n) {
		if (n==3) {
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (i==0 || i==2) star[r+i][c+j]=1;
					else if (i==1 && (j==0 || j==2)) star[r+i][c+j]=1;
				}
			}
		} else {
			printStar(r+0, c+0, n/3);
			printStar(r+0, c+n/3, n/3);
			printStar(r+0, c+n/3+n/3, n/3);
			
			printStar(r+n/3, c+0, n/3);
			printStar(r+n/3, c+n/3+n/3, n/3);
			
			printStar(r+n/3+n/3, c+0, n/3);
			printStar(r+n/3+n/3, c+n/3, n/3);
			printStar(r+n/3+n/3, c+n/3+n/3, n/3);
		}
	}
}
