import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int T;
	public static boolean reverse;
	public static int start;
	public static int end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String nums = br.readLine();
			String[] numArr = nums.substring(1,nums.length()-1).split(",");
			
			reverse = false;
			start = 0;
			end = n;
			
			for (int i=0; i<p.length(); i++) {
				char command = p.charAt(i);
				if (command=='R') {  // 배열 뒤집기
					reverse = !reverse;
				} else {
					D();
				}
			}
			
			if (start>end) {
				System.out.println("error");
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if (reverse) {
					for (int i=end-1; i>=start; i--) {
						sb.append(numArr[i]);
						if (i!=start) {
							sb.append(",");
						}
					}
				} else {
					for (int i=start; i<end; i++) {
						sb.append(numArr[i]);
						if (i!=end-1) {
							sb.append(",");
						}
					}
				}
				sb.append("]");
				System.out.println(sb);
			}
		}
	}

	private static void D() {
		if (reverse) {
			end--;
		} else {
			start++;
		}
	}
}