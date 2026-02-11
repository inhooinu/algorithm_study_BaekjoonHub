import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int maxCnt = Integer.MIN_VALUE;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
             st = new StringTokenizer(br.readLine());
             for (int j=0; j<N; j++) {
                 map[i][j] = Integer.parseInt(st.nextToken());
                 minH = Math.min(minH,map[i][j]);
                 maxH = Math.max(maxH,map[i][j]);
             }
        }

        // 물이 아래에서부터 차 오름
        for (int h=minH-1; h<maxH; h++) {
            // 물 채우기
            rain(h);

            // 안전한 영역 개수 세기
            visited = new boolean[N][N];  // 개수 세기 전 방문 초기화
            int cnt = count();

            // 최대 개수 계산
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.println(maxCnt);
    }

    private static void rain(int h) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j]<=h) {  // h 이하의 지역은 물에 잠김
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int count() {
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j]!=0 && !visited[i][j]) {  // 물에 잠기지 않았고, 아직 방문하지 않은 안전영역이면
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void bfs(int startR, int startC) {
        Queue<int[]> queue = new ArrayDeque<>();

        visited[startR][startC] = true;
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
                if (map[nr][nc]==0) continue;
                visited[nr][nc] = true;
                queue.offer(new int[] {nr,nc});
            }
        }
    }

    private static boolean inRange(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }
}
