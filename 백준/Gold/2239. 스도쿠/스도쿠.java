import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] nums;
	static boolean[][] rowNums;
	static boolean[][] colNums;
	static boolean[][] squareNums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nums = new int[9][9];
		rowNums = new boolean[9][10];
		colNums = new boolean[9][10];
		squareNums = new boolean[9][10];
		for (int i=0; i<9; i++) {
			String line = br.readLine();
			for (int j=0; j<9; j++) {
				nums[i][j] = line.charAt(j)-'0';
				if (nums[i][j]!=0) {
					int n = (i/3)*3 + j/3;
					rowNums[i][nums[i][j]] = true;
					colNums[j][nums[i][j]] = true;
					squareNums[n][nums[i][j]] = true;
				}
			}
		}
//		printNums();
		dfs();
	}

	private static void dfs() {
		int[] location = findZero();
		if (location==null) {  // 다 채웠으면
			printNums();
			System.exit(0);
		}
		int r = location[0];
		int c = location[1];
		for (int i=1; i<=9; i++) {  // 1~9까지의 선택에 대해
			// 같은 행, 같은 열, 3*3에 이미 존재하는 수인 경우는 탐색하지 않음
			if (!isAvailable(r,c,i)) continue;
			nums[r][c] = i;
			int n = (r/3)*3 + c/3;
			rowNums[r][i] = true;
			colNums[c][i] = true;
			squareNums[n][i] = true;
			dfs();
			squareNums[n][i] = false;
			colNums[c][i] = false;
			rowNums[r][i] = false;
			nums[r][c] = 0;
			
		}
	}

	private static boolean isAvailable(int r, int c, int num) {
		
		// 같은 행에 이미 존재하면 false
		if (rowNums[r][num]) return false;

		// 같은 열에 이미 존재하면 false
		if (colNums[c][num]) return false;
		
		// 3*3에 이미 존재하면 false
		int n = (r/3)*3 + c/3;
		if (squareNums[n][num]) return false;
		
		return true;
	}

	private static void printNums() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				sb.append(nums[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int[] findZero() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (nums[i][j]==0) {
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
}
