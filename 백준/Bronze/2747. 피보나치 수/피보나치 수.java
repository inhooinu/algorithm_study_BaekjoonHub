import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] fibo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		fibo = new int[n+1];
		
		for (int i=0; i<=n; i++) {
			if (i==0) fibo[i] = 0;
			else if (i==1) fibo[i] = 1;
			else fibo[i] = fibo[i-1] + fibo[i-2];
		}
		System.out.println(fibo[n]);
	}
}
