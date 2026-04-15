import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N, K;
	static ArrayList<Integer> nums;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		nums = new ArrayList<>();
		
		for (int n=1; n<=N; n++) {
			nums.add(n);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int idx = 0;
		while (!nums.isEmpty()) {
			idx = (idx+K-1)%nums.size();
//			System.out.println(nums.get(idx));
			if (nums.size()>1) sb.append(nums.get(idx)+", ");
			else sb.append(nums.get(idx));
			nums.remove(idx);
		}
		
		sb.append(">");
		System.out.println(sb);
	}
}
