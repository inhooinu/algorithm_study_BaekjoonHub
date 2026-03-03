import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int ledNum;  // led 개수
	static int[] led;  // led 상태
	static int sNum;  // 학생 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ledNum = Integer.parseInt(br.readLine());
		led = new int[ledNum+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=ledNum; i++) {
			led[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(led));
		sNum = Integer.parseInt(br.readLine());
		for (int i=0; i<sNum; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (gender==1) {  // 남학생인 경우
				
				for (int j=num; j<=ledNum; j+=num) {
					led[j] = (led[j]+1)%2;
				}
//				System.out.println(Arrays.toString(led));
				
			} else {  // 여학생인 경우
				
				led[num] = (led[num]+1)%2;
				int k = 1;
				while (true) {
					if (num-k<1 || num+k>ledNum) break;
					if (led[num-k]!=led[num+k]) break;
					led[num-k] = (led[num-k]+1)%2;
					led[num+k] = (led[num+k]+1)%2;
					k++;
//					System.out.println(Arrays.toString(led));
				}
			
			}
		}
		
		int cnt = 0;
		for (int i=1; i<=ledNum; i++) {
			System.out.print(led[i]+" ");
			cnt++;
			if (cnt==20) {
				System.out.println();
				cnt = 0;
			}
		}
	}

}
