import java.util.Scanner;

public class Main {
	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int cnt = 0;
		for (int i=1; i<=N; i++) {
			if (isHan(i)) cnt++;
		}
		System.out.println(cnt);
	}

	private static boolean isHan(int num) {
		String numStr = Integer.toString(num);
		if (numStr.length() <= 2) return true;
		
		int diff = (numStr.charAt(0) - '0') - (numStr.charAt(1) - '0');
		
		for (int i=1; i<numStr.length()-1; i++) {
			int curDiff = (numStr.charAt(i) - '0') - (numStr.charAt(i+1) - '0');
			if (curDiff != diff) return false;
		}
		
		return true;
	}
}
