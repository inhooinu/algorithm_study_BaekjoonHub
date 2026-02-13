import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static char[][] field;
	static boolean[][] visited;
    static int result;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        field = new char[12][6];
        for (int i=0; i<12; i++) {
            String line = br.readLine();
            for (int j=0; j<6; j++) {
                field[i][j] = line.charAt(j);
            }
        }
//        printField();
        
        while (true) {  // 모든 연쇄가 끝날 때까지

        	boolean exploded = false;
        	// 현재 상황에서 터질 수 있는 것들 모두 터뜨리기
        	visited = new boolean[12][6];
        	exploded = playRound();
        	
        	if (!exploded) break;  // 더 이상 터질 것이 없으면 끝
        	result++;
        	setField();  // 중력의 영향을 받아 아래쪽으로 떨어짐
        	
        }
        System.out.println(result);
	}
	
	private static void setField() {
	    for (int c = 0; c < 6; c++) {
	        int write = 11; // 이 위치부터

	        // 아래에서 위로 훑으며 뿌요를 아래로 모으기
	        for (int r = 11; r >= 0; r--) {
	            if (field[r][c] == '.') continue;

	            char puyo = field[r][c];
	            field[r][c] = '.';          // 원래 위치 비우기
	            field[write][c] = puyo;     // 아래로 떨어뜨리기
	            write--;
	        }
	    }
	}
	
	private static boolean playRound() {
		boolean exploded = false;
		
		for (int i=0; i<12; i++) {
			for (int j=0; j<6; j++) {
				if (field[i][j]!='.') {  // 뿌요가 있으면 터질 수 있는지 체크
					int cnt = countSameColor(i,j,field[i][j]);
					if (cnt>=4) {
						boom(i,j,field[i][j]);
						exploded = true;
					}
				}
			}
		}
		return exploded;
	}

	private static void boom(int startR, int startC, char color) {
		Queue<int[]> queue = new ArrayDeque<>();
    	
    	visited[startR][startC] = true;
    	field[startR][startC] = '.';
    	queue.offer(new int[] {startR,startC});
    	
    	while (!queue.isEmpty()) {
    		int[] cur = queue.poll();
    		int r = cur[0];
    		int c = cur[1];
    		
    		for (int dir=0; dir<4; dir++) {
    			int nr = r + dr[dir];
    			int nc = c + dc[dir];
    			if (!inRange(nr,nc)) continue;
    			if (visited[nr][nc]) continue;
    			if (field[nr][nc]!=color) continue;
    			visited[nr][nc] = true;
    			field[nr][nc] = '.';
    			queue.offer(new int[] {nr,nc});
     		}
    	}
	}

	private static int countSameColor(int startR, int startC, char color) {
		Queue<int[]> queue = new ArrayDeque<>();
    	boolean[][] visited = new boolean[12][6];
    	int cnt = 0;
    	
    	visited[startR][startC] = true;
    	cnt++;
    	queue.offer(new int[] {startR,startC});
    	
    	while (!queue.isEmpty()) {
    		int[] cur = queue.poll();
    		int r = cur[0];
    		int c = cur[1];
    		
    		for (int dir=0; dir<4; dir++) {
    			int nr = r + dr[dir];
    			int nc = c + dc[dir];
    			if (!inRange(nr,nc)) continue;
    			if (visited[nr][nc]) continue;
    			if (field[nr][nc]!=color) continue;
    			visited[nr][nc] = true;
    			cnt++;
    			queue.offer(new int[] {nr,nc});
     		}
    	}
//    	System.out.println(startR+" "+startC+" "+cnt);
		return cnt;
	}
	
	private static boolean inRange(int r, int c) {
		return r>=0 && r<12 && c>=0 && c<6;
	}

	private static void printField() {
        for (int i=0; i<12; i++) {
            for (int j=0; j<6; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
