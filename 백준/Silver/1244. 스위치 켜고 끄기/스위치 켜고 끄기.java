import java.util.*;
import java.io.*;

public class Main {

	static int ledCount;
	static int N; // 학생 수
	static int[] ledState;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ledCount = Integer.parseInt(br.readLine());
		ledState = new int[ledCount+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= ledCount; i++) {
			ledState[i] = Integer.parseInt(st.nextToken());
		}
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int led = Integer.parseInt(st.nextToken());
			if(gen == 1) {
				int x = 1;
				while(led * x <= ledCount) {
					togleLed(led*x);
					x++;
				}
			}else {
				togleLed(led);
				int x = 1;
				while(true) {
					int left = led - x;
					int right = led + x;
					if(left <= 0 || right > ledCount) break;
					if(ledState[left] != ledState[right]) break;
					togleLed(left);
					togleLed(right);
					x++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= ledCount; i++) {
			sb.append(ledState[i]).append(" ");
			if(i % 20 == 0) sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void togleLed(int n) {
		if(ledState[n] == 1) ledState[n] = 0;
		else ledState[n] = 1;
	}

}
