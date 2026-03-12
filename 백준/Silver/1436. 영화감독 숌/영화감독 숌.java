import java.util.Scanner;

public class Main {
	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int num = 666;
		int cnt = 0;
		while (true) {
			if (String.valueOf(num).contains("666")) {
				cnt++;
			}
			if (cnt==N) {
				System.out.println(num);
				break;
			}
			num++;
		}
	}
}
