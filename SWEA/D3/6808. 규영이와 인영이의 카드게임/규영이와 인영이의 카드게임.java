import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1~18 카드
// 규영이가 이기는 경우와 지는 경우 구하기
public class Solution {
	
	static int[] cardKY;
	static int[] cardIY;
	static boolean[] check;
	
	static boolean[] visited;
	static int[] orderIY;
	
	static int winCnt;
	static int loseCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t=1; t<=T; t++) {
			
			cardKY = new int[9];
			cardIY = new int[9];
			check = new boolean[19];
			visited = new boolean[9];
			orderIY = new int[9];
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<9; i++) {
				int inputNum = Integer.parseInt(st.nextToken());
				cardKY[i] = inputNum;
				check[inputNum] = true;
			}
			int size = 0;
			for (int i=1; i<=18; i++) {
				if (!check[i]) {
					cardIY[size] = i;
					size++;
				}
			}
			
//			System.out.println(Arrays.toString(cardKY));
//			System.out.println(Arrays.toString(cardIY));
			
			Arrays.sort(cardIY);
			// 인영이가 카드를 내는 모든 경우의 수 구하기
			winCnt = 0;
			loseCnt = 0;
			select(0);
			System.out.printf("#%d %d %d\n", t, winCnt, loseCnt);
		}
	}

	private static void select(int idx) {
		if (idx==9) {
			// 게임의 결과 구하기
//			System.out.println("규영"+Arrays.toString(cardKY));
//			System.out.println("인영"+Arrays.toString(orderIY));
			if (play(cardKY, orderIY)=="win") {
				winCnt++;
			} else if (play(cardKY, orderIY)=="lose") {
				loseCnt++;
			}
			
			return;
		}
		
		for (int i=0; i<9; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			orderIY[idx] = cardIY[i];
			select(idx+1);
			visited[i] = false;
		}
	}

	private static String play(int[] cardKY, int[] cardIY) {
		
		// 높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수 획득
		// 낮은 수가 적힌 카드를 낸 사람은 점수 없음
		int scoreKY = 0;
		int scoreIY = 0;
		for (int i=0; i<9; i++) {
			int ky = cardKY[i];
			int iy = cardIY[i];
			if (ky>iy) {
				scoreKY += ky+iy;
			} else {
				scoreIY += ky+iy;
			}
		}
		
		if (scoreKY>scoreIY) {
			return "win";
		} else if (scoreKY==scoreIY) {
			return "draw";
		} else {
			return "lose";
		}

	}
}
